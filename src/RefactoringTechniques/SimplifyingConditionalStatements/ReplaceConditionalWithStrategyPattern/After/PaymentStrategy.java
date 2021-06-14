package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithStrategyPattern.After;

public interface PaymentStrategy {

    double getPay(double salary);
}
