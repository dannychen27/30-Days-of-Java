package RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton;

public class ReplaceConstructorsWithSingleton {

    public static void main(String[] args) {
        // source:
        // - https://www.youtube.com/watch?v=NhFmQl1FA5Y&list=PLGLfVvz_LVvSuz6NuHAzpM52qKM6bPlCV&index=5
        // code refactoring part 5

        // the good thing with a factory is that you don't have to touch the getMedalType() method
        // every time you add a new medal type.
        MedalFactory medalFactory = new MedalFactory();
        Athlete goldWinner = medalFactory.getMedalType("RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton.GoldWinner", "Gus Kenworthy");
        Athlete silverWinner = medalFactory.getMedalType("RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton.SilverWinner", "Shawn Mendes");
        Athlete bronzeWinner = medalFactory.getMedalType("RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton.BronzeWinner", "Charlie Puth");

        // a singleton only allows a single instance of an object.
        Athlete goldWinnerNew = medalFactory.getMedalType("RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton.GoldWinner", "Shawn Mendes");
        Athlete silverWinnerNew = medalFactory.getMedalType("RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton.SilverWinner", "Charlie Puth");
        Athlete bronzeWinnerNew = medalFactory.getMedalType("RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton.BronzeWinner", "Gus Kenworthy");
        System.out.println("Gold Winner: " + goldWinner.getAthleteName());
        System.out.println("Silver Winner: " + silverWinner.getAthleteName());
        System.out.println("Bronze Winner: " + bronzeWinner.getAthleteName());

        System.out.println("Gold Winner: " + goldWinnerNew.getAthleteName());
        System.out.println("Silver Winner: " + silverWinnerNew.getAthleteName());
        System.out.println("Bronze Winner: " + bronzeWinnerNew.getAthleteName());

    }
}
