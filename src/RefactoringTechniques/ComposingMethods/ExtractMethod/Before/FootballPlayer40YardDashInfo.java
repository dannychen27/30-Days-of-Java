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

// TODO: Move these into separate classes before pushing this code to github.

/*
// Working with local variables

double average 0.0;
double[] dashTimes = {4.36, 4.39, 4.41};
double totalDashTimes = 0.0;
for (int i = 0; i < dashTimes.length; i++) {
     totalDashTimes += dashTimes[i];
}
average = totalDashTimes / numOfTimes.length;

// Replace with

double[] dashTimes = {4.36, 4.39, 4.41};
double average = getAvgDashTime(dashTimes);

public static double getAvgDashTime(double[] dashTimes) {
    double totalDashTimes = 0.0;
    for(int i = 0; i < dashTimes.length; i++){
        totalDashTimes += dashTimes[i];
    }
    return totalDashTimes / dashTimes.length;
}
*/

/*
 // If the code is as clear as a method name use the code instead
 String inTop15 = checkIfInTop15(avg40YdTime) ? " *Top 15\n" : "\n";

 // Remove the method call here:
 public boolean checkIfInTop15(double avg40YdTime) {
    return avg40YdTime < 4.41;
 }

 // Replace it with:
 String inTop15 = (avg40YdTime < 4.41) ? " *Top 15\n" : "\n";
 System.out.print(inTop15);

 This method shouldn't have been extracted because it didn't
 make the code more understandable.
/*



/*

// Know when temps are getting in the way
// To get rid of a temp:
// 1. Declare it as final to make sure it is declared only once
// 2. Replace the right side with the temp name
double dashTime = 4.50;
double avg40YdDash = getAvgDashTime();
String dashGrade = ((dashTime <= avg40YdDash) ? "Good" : "Bad");
System.out.print("That was a " + dashGrade + " time");

// Replace with:

String dashGrade = ((getAvgDashTime() >= 4.50) ? "Good" : "Bad");
System.out.print("That was a " + dashGrade + " time");
 */

/*
// Replacing a temp with a Query


// the temp is used once, and doesn't add to understanding
// the temp holds the value of an expression

double avgDashTime = totalDashTimes / totalDashes;
if (avgDashTime > 4.41) {
    System.out.println("Average Time");
}

// Better Solution
if (avgDashTime() > 4.41) {
    System.out.println("Average Time");
}

double avgDashTime() {
    return totalDashTimes / totalDashes;
}
*/
