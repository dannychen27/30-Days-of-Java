package RefactoringTechniques.ComposingMethods.RemoveTemporaryVariable.Before;

class FootballPlayer40YardDashInfo {

    public static void main(String[] args) {
        double dashTime = 4.50;
        double avg40YdDash = getAvgDashTime(13.0, 3);
        String dashGrade = ((dashTime <= avg40YdDash) ? "good" : "bad");
        System.out.println("That was a " + dashGrade + " time");
    }

    private static double getAvgDashTime(double totalDashTimes, int totalDashes) {
        return totalDashTimes / totalDashes;
    }
}
