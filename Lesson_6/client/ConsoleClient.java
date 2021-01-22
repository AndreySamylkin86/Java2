package Lesson_6.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean online;

    public ConsoleClient() {
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            this.online = true;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = scanner.nextLine();
                            if (str.equals("/end")) {
                                online = false;
                                out.writeUTF(str);
                                break;
                            }
                            out.writeUTF(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            while (online) {
                String str = in.readUTF();

                if (str.equals("/end")) {
                    System.out.println("Сервер отключился по команде " + str);
                    System.exit(0);
                    break;
                }
                System.out.println("Сервер: " + str);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

