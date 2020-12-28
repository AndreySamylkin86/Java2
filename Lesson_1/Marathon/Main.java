package Lesson_1.Marathon;

import Lesson_1.Competitor.*;
import Lesson_1.Obstacle.Course;
import Lesson_1.Obstacle.Wall;
import Lesson_1.Obstacle.Water;

public class Main {
    public static void main(String[] args) {
       Team team = new Team("Winers", new Human("Bob"), new Cat("Barsik"), new Dog("Bobik"));
       Course course = new Course(new Cross(70), new Wall(2), new Water(20));
       course.start(team);
       team.showResults();

    }
}
