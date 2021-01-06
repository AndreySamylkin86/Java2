package Lesson_3.Task_2;

public class Main {
    public static void main(String[] args) {

        PhoneDirectory.add("Petrov", 8_935_391_11_11L);
        PhoneDirectory.add("Sidorov", 8_935_391_22_22L);
        PhoneDirectory.add("Petrov", 8_935_391_33_33L);
        PhoneDirectory.add("Ivanov", 8_935_391_44_44L);
        PhoneDirectory.add("Sidorov", 8_935_391_55_55L);
        PhoneDirectory.add("Petrov", 8_935_391_66_66L);

        System.out.println("Фамилия Petrov, номер телефона: " + PhoneDirectory.get("Petrov"));
        System.out.println("Фамилия Ivanov, номер телефона: " + PhoneDirectory.get("Ivanov"));
        System.out.println("Фамилия Sidorov, номер телефона: " + PhoneDirectory.get("Sidorov"));
    }
}
