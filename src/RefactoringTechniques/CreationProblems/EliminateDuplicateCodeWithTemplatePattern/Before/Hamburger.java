package RefactoringTechniques.CreationProblems.EliminateDuplicateCodeWithTemplatePattern.Before;

class Hamburger {

    private boolean customerWantsCondiments;

    Hamburger() {
        customerWantsCondiments = true;
    }

    void makeSandwich() {
        System.out.println("\n------NEW ORDER------\n");
        cutBun();
        addMeat();   // TODO: This is the only thing different about Hamburger
        addVegetables();
        if (customerWantsCondiments) {
            addCondiments();
        }
        wrapSandwich();
    }

    private void cutBun() {
        System.out.println("The bun was cut.");
    }

    private void addMeat() {
        System.out.println("Hamburger added.");
    }

    private void addVegetables() {
        System.out.println("Added lettuce, onions, and tomatoes.");
    }

    private void addCondiments() {
        System.out.println("Special sauce added.");
    }

    private void wrapSandwich() {
        System.out.println("The sandwich was wrapped.");
    }
}
