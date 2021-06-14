package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithStrategyPattern.After;

public class Bonus15Percent implements PaymentStrategy {

    public double getPay(double salary) {
        return salary + salary * 0.15; // I write the expression like this to avoid floating point issues.
    }
}
