package RefactoringTechniques.BuilderPattern.After;

class BLTBuilder extends SandwichBuilder {

    public void buildBread() {
        sandwich.setBread("White bread");
    }

    public void buildVegetables() {
        sandwich.setVegetables("Lettuce and tomato");
    }

    public void buildMeat() {
        sandwich.setMeat("Bacon");
    }

    public void buildCheese() {
        sandwich.setCheese("No cheese");
    }

    public void buildCondiments() {
        sandwich.setCondiments("Mayonnaise");
    }
}
