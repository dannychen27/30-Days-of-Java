package RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithSingleton;

class Athlete {

    private String athleteName = "";

    String getAthleteName() {
        return athleteName;
    }

    void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public static Athlete getInstance() {
        return null;
    }
}
