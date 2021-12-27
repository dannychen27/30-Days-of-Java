package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithStrategyPattern.Before;

class Employee {

    private boolean bonus = false;
    private double salary = 0.0;
    private double bonusAmount = 0.15;

    Employee() {}

    Employee(double salary, boolean bonus) {
        super();
        this.bonus = bonus;
        this.salary = salary;
    }

    Employee(double salary, boolean bonus, double bonusAmount) {
        super();
        this.bonus = bonus;
        this.salary = salary;
        this.bonusAmount = bonusAmount;
    }

    public double getSalary() {
        if (bonus) {
            return salary + (salary * bonusAmount);
        } else {
            return salary;
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
