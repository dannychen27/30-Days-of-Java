package RefactoringTechniques.ComposingMethods.ExtractMethod.After;

import java.util.ArrayList;

class FootballPlayer40YardDashInfo {

    private ArrayList<FootballPlayer> players = new ArrayList<>();

    private void addFootballPlayer(FootballPlayer footballPlayer) {
        players.add(footballPlayer);
    }

    private void printPlayerInfo() {
        printTitles();
        printPlayersWith40Avg();
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

    private void printTitles() {
        System.out.printf("%-15s %15s", "Name", "Avg 40 Time\n");
        printCharacterMultipleTimes('_', 30);  // print dashes under titles
    }

    private void printCharacterMultipleTimes(char characterToPrint, int numTimes) {
        for (int i = 0; i < numTimes; i++) {
            System.out.print(characterToPrint);
        }
        System.out.println();
    }

    private void printPlayersWith40Avg() {
        for (FootballPlayer player : players) {
            printPlayerAvg40YdTime(player);
        }
    }

    private void printPlayerAvg40YdTime(FootballPlayer player) {
        System.out.printf("%-19s", player.getName());
        double avg40YdTime = getAvg40YdTimes(player);
        System.out.printf("%1$.2f", avg40YdTime);
        System.out.println();
    }

    private double getAvg40YdTimes(FootballPlayer player) {
        double total40YdDashTimes = 0.0;
        double[] fortyYardDashTimes = player.get40YardDashTimes();
        for (double fortyYardDashTime : fortyYardDashTimes) {
            total40YdDashTimes += fortyYardDashTime;
        }
        return total40YdDashTimes / player.get40YardDashTimes().length;
    }
}
