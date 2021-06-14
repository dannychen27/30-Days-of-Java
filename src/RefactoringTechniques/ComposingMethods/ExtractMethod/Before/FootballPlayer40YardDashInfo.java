package RefactoringTechniques.ComposingMethods.ExtractMethod.Before;

import java.util.ArrayList;

class FootballPlayer40YardDashInfo {

    private ArrayList<FootballPlayer> players = new ArrayList<>();

    private void addFootballPlayer(FootballPlayer footballPlayer) {
        players.add(footballPlayer);
    }

    private void printPlayerInfo() {
        System.out.printf("%-15s %15s", "Name", "Avg 40 Time\n");
        // print dashes under titles
        for (int i = 0; i < 30; i++) {
            System.out.print("_");
        }
        System.out.println();

        double avg40YdTime = 0.0;
        for (FootballPlayer player : players) {
            System.out.printf("%-19s", player.getName());
            double total40YdDashTimes = 0.0;
            double[] fortyYardDashTimes = player.get40YardDashTimes();
            for (int i = 0; i < player.get40YardDashTimes().length; i++) {
                total40YdDashTimes += fortyYardDashTimes[i];
            }
            avg40YdTime = total40YdDashTimes / player.get40YardDashTimes().length;
            System.out.printf("%1$.2f", avg40YdTime);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FootballPlayer40YardDashInfo fb40Dash = new FootballPlayer40YardDashInfo();

        // add Clark Kent for example
        double[] cKent40YdDashTimes = {4.36, 4.39, 4.41};
        FootballPlayer clarkKent = new FootballPlayer("Clark Kent", cKent40YdDashTimes);
        fb40Dash.addFootballPlayer(clarkKent);

        // add Bruce Wayne for example
        double[] bWayne40YdDashTimes = {4.42, 4.43, 4.49};
        FootballPlayer bruceWayne = new FootballPlayer("Bruce Wayne", bWayne40YdDashTimes);
        fb40Dash.addFootballPlayer(bruceWayne);

        fb40Dash.printPlayerInfo();
    }
}
