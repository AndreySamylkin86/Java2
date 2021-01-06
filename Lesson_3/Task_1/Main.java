package Lesson_3.Task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String[] arrayWords;
    private static ArrayList<String> uniqueWords = new ArrayList<>();

    public static void main(String[] args) {
// Создаём массив строк  arrayWords из файла wordlist.txt
        arrayWordsInitialize();

// Определяем уникальные слова в массиве строк arrayWords
        uniqueWords();

// Считаем, сколько раз встречается каждое слово
        repeatedWords();
    }

    public static void arrayWordsInitialize() {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scan = new Scanner(new File("C:\\Users\\Андрей\\Desktop\\Java1\\src\\Lesson_3\\Task_1\\wordlist.txt"))) {
            while (scan.hasNextLine()) {
                list.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        arrayWords = list.toArray(new String[0]);
        System.out.println("Количество всех слов " + arrayWords.length);
    }

    public static void uniqueWords() {
        for (int i = 0; i < arrayWords.length; i++) {
            String str = arrayWords[i];
            boolean worldIsUnique = true;

            for (String x : uniqueWords) {
                if (x.equals(str))
                    worldIsUnique = false;
            }
            if (worldIsUnique)
                uniqueWords.add(str);
        }
        System.out.println("Количество уникальных слов " + uniqueWords.size());
        System.out.println("Список уникальных слов " + uniqueWords);
    }

    public static void repeatedWords() {
        System.out.println("Повторяющиеся слова:");

        int count;
        for (int i = 0; i < uniqueWords.size(); i++) {
            String str = uniqueWords.get(i);
            count = 0;
            for (String x : arrayWords) {
                if (x.equals(str))
                    count++;
            }
            if (count != 1)
                System.out.println("Слово \'" + str + "\' встречается " + count + " раз/а");
        }
    }
}
