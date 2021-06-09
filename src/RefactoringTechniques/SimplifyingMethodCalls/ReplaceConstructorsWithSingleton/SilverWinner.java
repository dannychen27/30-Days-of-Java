package RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton;

public class SilverWinner extends Athlete {

    private static SilverWinner silverAthlete = null;

    private SilverWinner(String athleteName) {
        setAthleteName(athleteName);
    }

    public static SilverWinner getInstance(String athleteName) {
        if (silverAthlete == null) {
            silverAthlete = new SilverWinner(athleteName);
        }
        return silverAthlete;
    }
}
