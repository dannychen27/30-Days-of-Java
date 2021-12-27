package RefactoringTechniques.CreationProblems.EliminateDuplicateCodeWithTemplatePattern.Before;

class VeggieSub {

    private boolean customerWantsCondiments;

    VeggieSub() {
        customerWantsCondiments = true;
    }

    void makeSandwich() {
        System.out.println("\n------NEW ORDER------\n");
        cutBun();
        addVegetables();
        if (customerWantsCondiments) {
            addCondiments();
        }
        wrapSandwich();
    }

    private void cutBun() {
        System.out.println("The bun was cut.");
    }

    private void addVegetables() {
        System.out.println("Added lettuce, onions, and tomatoes.");
    }

    private void addCondiments() {
        System.out.println("Vinegar and oil added.");
    }

    private void wrapSandwich() {
        System.out.println("The sandwich was wrapped.");
    }
}
