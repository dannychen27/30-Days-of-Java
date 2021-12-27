package RefactoringTechniques.MoveEmbellishmentsUsingDecoratorPattern.After;

class Perm extends HairCutDecorator {

    public Perm(HairCut hairCut) {
        super(hairCut);
    }

    public String getDescription() {
        return hairCut.getDescription() + "\nAdd chemicals and put hair in rollers.";
    }

    public double getCost() {
        return hairCut.getCost() + 75.00;
    }
}
