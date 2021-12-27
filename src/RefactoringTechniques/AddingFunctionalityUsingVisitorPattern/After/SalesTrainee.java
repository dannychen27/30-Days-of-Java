package RefactoringTechniques.AddingFunctionalityUsingVisitorPattern.After;

class SalesTrainee implements Visitable {

    private int sickDays;
    private int failedTests;
    private double salary;

    SalesTrainee(int sickDays, int failedTests, double salary) {
        this.sickDays = sickDays;
        this.failedTests = failedTests;
        this.salary = salary;
    }

    int getSickDays() {
        return sickDays;
    }

    int getFailedTests() {
        return failedTests;
    }

    double getSalary() {
        return salary;
    }

    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
