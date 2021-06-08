package RefactoringTechniques.ComposingMethods.MakeMethodInline.After;

public class FootballPlayer40YardDashInfo {

    public static void main(String[] args) {
        double avg40YdTime = 4.6;
        String inTop15 = (avg40YdTime < 4.41) ? "Top 15" : "Not in Top 15";
        System.out.println(inTop15);
    }
}
