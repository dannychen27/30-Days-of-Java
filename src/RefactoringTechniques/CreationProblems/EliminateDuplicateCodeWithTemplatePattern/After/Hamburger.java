package RefactoringTechniques.CreationProblems.EliminateDuplicateCodeWithTemplatePattern.After;

class Hamburger extends Sandwich {

    void addMeat() {
        System.out.println("Hamburger added.");
    }

    void addCondiments() {
        System.out.println("Special sauce added.");
    }
}
