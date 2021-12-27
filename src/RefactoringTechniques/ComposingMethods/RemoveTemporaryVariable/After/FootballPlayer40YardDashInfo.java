package RefactoringTechniques.ComposingMethods.RemoveTemporaryVariable.After;

class FootballPlayer40YardDashInfo {

    public static void main(String[] args) {
        String dashGrade = ((getAvgDashTime(13.0, 3) >= 4.50) ? "good" : "bad");
        System.out.println("That was a " + dashGrade + " time");
    }

    private static double getAvgDashTime(double totalDashTimes, int totalDashes) {
        return totalDashTimes / totalDashes;
    }
}
