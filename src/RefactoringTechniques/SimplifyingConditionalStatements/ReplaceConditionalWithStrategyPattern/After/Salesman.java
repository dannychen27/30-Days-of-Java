package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithStrategyPattern.After;

class Salesman extends Employee {

    Salesman(double salary) {
        super(salary);
    }

    Salesman(double salary, PaymentStrategy paymentStrategy) {
        super(salary, paymentStrategy);
    }
}
