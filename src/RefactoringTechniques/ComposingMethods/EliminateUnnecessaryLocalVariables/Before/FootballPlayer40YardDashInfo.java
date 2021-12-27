package RefactoringTechniques.ComposingMethods.EliminateUnnecessaryLocalVariables.Before;

class FootballPlayer40YardDashInfo {

    public static void main(String[] args) {
        double average = 0.0;
        double[] dashTimes = {4.36, 4.39, 4.41};
        double totalDashTimes = 0.0;
        for (int i = 0; i < dashTimes.length; i++) {
            totalDashTimes += dashTimes[i];
        }
        average = totalDashTimes / dashTimes.length;
        System.out.println("The average dash time is " + average);
    }
}
