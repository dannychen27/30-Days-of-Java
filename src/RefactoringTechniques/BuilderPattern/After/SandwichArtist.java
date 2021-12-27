package RefactoringTechniques.BuilderPattern.After;

class SandwichArtist {

    private SandwichBuilder sandwichBuilder;

    public void setSandwichBuilder(SandwichBuilder newSandwichBuilder) {
        sandwichBuilder = newSandwichBuilder;
    }

    public Sandwich getSandwich() { return sandwichBuilder.getSandwich(); }

    public void takeSandwichOrder() {
        sandwichBuilder.makeSandwich();
        sandwichBuilder.buildBread();
        sandwichBuilder.buildVegetables();
        sandwichBuilder.buildMeat();
        sandwichBuilder.buildCheese();
        sandwichBuilder.buildCondiments();
    }
}
