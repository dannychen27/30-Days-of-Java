package RefactoringTechniques.CreationProblems.EliminateDuplicateCodeWithTemplatePattern.After;

abstract class Sandwich {

    // cannot override this template in subclasses
    final void makeSandwich() {
        System.out.println("\n------NEW ORDER------\n");
        cutBun();
        if (customerWantsMeat()) {
            addMeat();
        }
        addVegetables();
        if (customerWantsCondiments()) {
            addCondiments();
        }
        wrapSandwich();
    }

    private void cutBun() {
        System.out.println("The bun was cut.");
    }

    boolean customerWantsMeat() {
        return true;
    }

    abstract void addMeat();  // we want this method to be subclassed and overridden!

    private void addVegetables() {
        System.out.println("Added lettuce, onions, and tomatoes.");
    }

    private boolean customerWantsCondiments() {
        return true;
    }

    abstract void addCondiments();  // we want this method to be subclassed and overridden!

    private void wrapSandwich() {
        System.out.println("The sandwich was wrapped.");
    }
}
