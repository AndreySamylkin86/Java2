package Lesson_1.Obstacle;

import Lesson_1.Competitor.Competitor;
import Lesson_1.Competitor.Team;

public class Course {
private Obstacle[] obstacle;

      public Course(Obstacle... obstacle) {
            this.obstacle = obstacle;
            }

      public  void start (Team team){
            for (Competitor c : team.getCompetitors()) {
                  for (Obstacle o : obstacle) {
                        o.doIt(c);
                        if (!c.isOnDistance()) break;
                  }
            }

      }

}
