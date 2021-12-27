package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithPolymorphism.After;

class Animal {

    private String sound = "";

    Animal(String sound) {
        super();
        this.sound = sound;
    }

    String getSound() {
        return sound;
    }

    public void setSound() {
        this.sound = sound;
    }
}
