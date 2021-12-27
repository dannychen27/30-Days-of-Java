package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithStrategyPattern.After;

class Employee {

    private double salary = 0.0;

    private PaymentStrategy paymentStrategy = new NoBonus();

    Employee(double salary) {
        this.salary = salary;
    }

    Employee(double salary, PaymentStrategy paymentStrategy) {
        this.salary = salary;
        this.paymentStrategy = paymentStrategy;
    }

    void setBonusOption(PaymentStrategy newPaymentStrategy) {
        paymentStrategy = newPaymentStrategy;
    }

    double getPay() {
        return paymentStrategy.getPay(this.salary);
    }
}


