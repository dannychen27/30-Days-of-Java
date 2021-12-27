package RefactoringTechniques.CreationProblems.EliminateDuplicateCodeWithTemplatePattern.After;

class VeggieSub extends Sandwich {

    boolean customerWantsMeat() {
        return false;
    }

    void addMeat() {}

    void addCondiments() {
        System.out.println("Vinegar and oil added.");
    }
}
