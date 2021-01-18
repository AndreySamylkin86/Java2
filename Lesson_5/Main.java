package Lesson_5;

import java.util.ArrayList;

public class Main {
    static final int size = 10_000_000;
    static final int numberOfThreads = 10;

    public static void main(String[] args) {
//        singleThreaded(size);
        multithreaded(size, numberOfThreads);
    }

    public static void singleThreaded(int size) {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void multithreaded(int size, int numberOfThreads) {

        if (size % numberOfThreads != 0)
            System.out.println("Массив размера " + size + " нельзя разбить на " + numberOfThreads + " потока/ов.");
        else {
            float[] arr = new float[size];

            int h = size / numberOfThreads;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }

            ArrayList<float[]> arrays = new ArrayList<>();
            for (int i = 0; i < numberOfThreads; i++) {
                arrays.add(new float[h]);
            }

            long a = System.currentTimeMillis();

            int position = 0;
            for (float[] x : arrays) {
                System.arraycopy(arr, position, x, 0, h);
                position = position + h;
            }
//           count - счётчик потоков
            int count = 0;
            for (int i = 0; i < arrays.size(); i++) {
                count++;
                float[] x = arrays.get(i);

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < x.length; i++) {
                            x[i] = (float) (x[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                        }
                    }
                });

                t.start();

                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                System.out.println("Отработал поток "+ count );
            }

            position = 0;
            for (float[] x : arrays) {
                System.arraycopy(x, 0, arr, position, h);
                position = position + h;
            }

            System.currentTimeMillis();
            System.out.println(System.currentTimeMillis() - a);
        }
    }
}
