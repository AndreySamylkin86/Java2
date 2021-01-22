
package Lesson_6.ser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleServer  {

    private ServerSocket server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private boolean online;

    public ConsoleServer() {

        this.online = true;

        Scanner scanner = new Scanner(System.in);
        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            socket = server.accept();
            System.out.println("Клиент подключился");

            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Вы подключились к серверу");

        new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = scanner.nextLine();
                            if (str.equals("/end")) {
                                out.writeUTF (str);
                                System.exit(0);

                                try {
                                    in.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                online =false;
                                break;
                            }
                            out.writeUTF (str);
                        }
                    } catch (IOException  e) {
                        e.printStackTrace();
                    }

                }
            }).start();

            while (online) {
                String str = in.readUTF();
                if (str.equals("/end")) {
                    out.writeUTF("/serverClosed");
                    System.out.println("Клиент отключился по команде " + str);
                    System.exit(0);
                    break;
                }
                out.writeUTF ("Ваше сообщение получено");
                System.out.println("Клиент: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("finally 1");
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();
            System.out.println("finally 2");
        }
    }
}
