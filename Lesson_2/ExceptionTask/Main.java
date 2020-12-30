package Lesson_2.ExceptionTask;

public class Main {

    public static void main(String[] args) {

// Генерация исключения MyArraySizeException
        String[][] testSize = {
                {"1", "2", "3", "4"},
                {"5", "6", "3", "7"},
                {"8", "9", "3", "4", "x"},
                {"4", "3", "5", "2"},
        };

        Mass mass1 = new Mass(testSize);

        System.out.println("Работа исключения MyArraySizeException");
        try {
            System.out.println(mass1.sumArray(testSize));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

// Генерация исключения MyArrayDataException
        String[][] testData = {
                {"1", "2", "3", "4"},
                {"5", "6", "3", "7"},
                {"8", "9", "4", "3"},
                {"строка", "12", "13", "14"},
        };

        Mass mass2 = new Mass(testData);

        System.out.println("\nРабота исключения MyArrayDataException");
        try {
            System.out.println(mass2.sumArray(testData));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

// Работа метода без исключений
        String[][] testOk = {
                {"1", "2", "3", "4"},
                {"5", "6", "3", "7"},
                {"8", "9", "4", "3"},
                {"11", "12", "13", "14"},
        };

        Mass mass3 = new Mass(testOk);

        System.out.println("\nРабота метода без исключений");
        try {
            System.out.println(mass3.sumArray(testOk));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }
}

