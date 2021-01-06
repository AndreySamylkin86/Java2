package Lesson_3.Task_2;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneDirectory {
    private static HashMap<String, ArrayList<Long>> directory = new HashMap<>();

    public static ArrayList<Long> get(String lastName) {
        return directory.get(lastName);
    }

    public static void add(String lastName, Long phoneNumber) {
        ArrayList<Long> list;
        if (directory.containsKey(lastName)) {
            list = directory.get(lastName);
            list.add(phoneNumber);
        } else {
            list = new ArrayList<>();
            list.add(phoneNumber);
        }

        directory.put(lastName, list);
    }
}
