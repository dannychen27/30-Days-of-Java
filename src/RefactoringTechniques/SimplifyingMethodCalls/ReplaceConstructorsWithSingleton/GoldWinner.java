package RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton;

public class GoldWinner extends Athlete {

    private static GoldWinner goldAthlete = null;

    private GoldWinner(String athleteName) {
        setAthleteName(athleteName);
    }

    public static GoldWinner getInstance(String athleteName) {
        if (goldAthlete == null) {
            goldAthlete = new GoldWinner(athleteName);
        }
        return goldAthlete;
    }
}
