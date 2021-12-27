package RefactoringTechniques.MoveEmbellishmentsUsingDecoratorPattern.After;

abstract class HairCutDecorator implements HairCut {

    protected HairCut hairCut;

    public HairCutDecorator(HairCut hairCut) {
        this.hairCut = hairCut;
    }

    public String getDescription() {
        return hairCut.getDescription();
    }

    public double getCost() {
        return hairCut.getCost();
    }
}
