package RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton;

public class BronzeWinner extends Athlete {

    private static BronzeWinner bronzeAthlete = null;

    private BronzeWinner(String athleteName) {
        setAthleteName(athleteName);
    }

    public static BronzeWinner getInstance(String athleteName) {
        if (bronzeAthlete == null) {
            bronzeAthlete = new BronzeWinner(athleteName);
        }
        return bronzeAthlete;
    }
}
