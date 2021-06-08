package RefactoringTechniques.ComposingMethods.ReplaceTemporaryVariableWithQuery.Before;

public class FootballPlayer40YardDashInfo {

    public static void main(String[] args) {
        double totalDashTimes = 13.0;
        int totalDashes = 3;
        double avgDashTime = totalDashTimes / totalDashes;
        if (avgDashTime > 4.41) {
            System.out.println("Average Time");
        } else {
            System.out.println("Excellent Time");
        }
    }
}
