package RefactoringTechniques.ComposingMethods.MakeMethodInline.Before;

public class FootballPlayer40YardDashInfo {

    public static void main(String[] args) {
        double avg40YdTime = 4.6;
        // Remove the method call below
        String inTop15 = checkIfInTop15(avg40YdTime) ? "Top 15" : "Not in Top 15";
        System.out.println(inTop15);
    }

    // This method shouldn't have been extracted because it doesn't
    // make the code more understandable.
    private static boolean checkIfInTop15(double avg40YdTime) {
        return avg40YdTime < 4.41;
    }
}
