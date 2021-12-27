package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithStrategyPattern.After;

public class NoBonus implements PaymentStrategy {

    public double getPay(double salary) {
        return salary;
    }
}
