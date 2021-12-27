package RefactoringTechniques.ComposingMethods.EliminateUnnecessaryLocalVariables.After;

class FootballPlayer40YardDashInfo {

    public static void main(String[] args) {
        double[] dashTimes = {4.36, 4.39, 4.41};
        double average = getAvgDashTime(dashTimes);
        System.out.println("The average dash time is " + average);
    }

    private static double getAvgDashTime(double[] dashTimes) {
        double totalDashTimes = 0.0;
        for (int i = 0; i < dashTimes.length; i++) {
            totalDashTimes += dashTimes[i];
        }
        return totalDashTimes / dashTimes.length;
    }
}
