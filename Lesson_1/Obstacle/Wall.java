package Lesson_1.Obstacle;

import Lesson_1.Competitor.Competitor;
import Lesson_1.Obstacle.Obstacle;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}
