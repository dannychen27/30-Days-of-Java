package RefactoringTechniques.BuilderPattern.After;

// This is the builder abstract class. It defines
// all the methods that each Sandwich object must
// contain. What these methods do is completely
// up to the subclass that extends the builder

abstract class SandwichBuilder {

    Sandwich sandwich;

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void makeSandwich() {
        sandwich = new Sandwich();
    }

    public abstract void buildBread();

    public abstract void buildVegetables();

    public abstract void buildMeat();

    public abstract void buildCheese();

    public abstract void buildCondiments();
}
