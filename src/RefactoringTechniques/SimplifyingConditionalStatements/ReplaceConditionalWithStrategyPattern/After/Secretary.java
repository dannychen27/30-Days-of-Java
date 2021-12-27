package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithStrategyPattern.After;

class Secretary extends Employee {

    Secretary(double salary) {
        super(salary);
    }

    Secretary(double salary, PaymentStrategy paymentStrategy) {
        super(salary, paymentStrategy);
    }
}
