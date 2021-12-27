package RefactoringTechniques.MoveEmbellishmentsUsingDecoratorPattern.After;

public class RegularHairCut implements HairCut {

    public String getDescription() {
        return "Trim the hair";
    }

    public double getCost() {
        return 10.00;
    }
}
