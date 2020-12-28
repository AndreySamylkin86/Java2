package Lesson_1.Competitor;

public class Team {
    private String nameTeam;
    private Competitor[] competitors;


    public Team(String nameTeam, Competitor... competitors) {
        this.nameTeam = nameTeam;
        this.competitors = competitors;
        }
    public Competitor[] getCompetitors () {
        return competitors;
    }

    public void showResults() {
        System.out.println("Результаты марафона");
        for (Competitor x : competitors ) {
            x.info();
        }
    }

}
