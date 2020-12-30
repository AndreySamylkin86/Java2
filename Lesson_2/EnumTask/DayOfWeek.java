package Lesson_2.EnumTask;


public enum DayOfWeek { MONDAY, TUESDAY,WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public static String getWorkingHours (DayOfWeek day) {
        switch (day){
            case MONDAY: return "40";
            case TUESDAY: return "32";
            case WEDNESDAY: return "24";
            case THURSDAY: return "16";
            case FRIDAY: return "8";
            case SATURDAY: return "Выходной";
            case SUNDAY: return "Выходной";
        }
        return "Такого дня недели нет";

    }
}
