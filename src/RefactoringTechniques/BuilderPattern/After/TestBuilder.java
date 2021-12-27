package RefactoringTechniques.BuilderPattern.After;

class TestBuilder {

    public static void main(String[] args) {
        SandwichArtist paul = new SandwichArtist();
        SandwichBuilder bltBuilder = new BLTBuilder();
        paul.setSandwichBuilder(bltBuilder);
        paul.takeSandwichOrder();
        Sandwich bltSandwich = paul.getSandwich();

        System.out.println(bltSandwich);
    }
}
