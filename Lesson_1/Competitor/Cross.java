package Lesson_1.Competitor;

import Lesson_1.Competitor.Competitor;
import Lesson_1.Obstacle.Obstacle;

public class Cross extends Obstacle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}
