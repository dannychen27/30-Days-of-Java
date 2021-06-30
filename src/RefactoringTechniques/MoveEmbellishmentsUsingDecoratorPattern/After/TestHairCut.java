package RefactoringTechniques.MoveEmbellishmentsUsingDecoratorPattern.After;

class TestHairCut {

    public static void main(String[] args) {
        // perm is the embellishment, regular haircut is the core
        HairCut permAndCut = new Perm(new RegularHairCut());
        System.out.println("SERVICES");
        System.out.println(permAndCut.getDescription());
        System.out.println("Price $" + permAndCut.getCost());
    }
}
