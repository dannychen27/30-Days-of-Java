package RefactoringTechniques.ComposingMethods.ReplaceTemporaryVariableWithQuery.After;

public class FootballPlayer40YardDashInfo {

    public static void main(String[] args) {
        // Better Solution
        if (avgDashTime(13.0, 3) > 4.41) {
            System.out.println("Average Time");
        } else {
            System.out.println("Excellent Time");
        }
    }

    private static double avgDashTime(double totalDashTimes, int totalDashes) {
        return totalDashTimes / totalDashes;
    }
}
