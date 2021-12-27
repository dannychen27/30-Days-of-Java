package RefactoringTechniques.AddingFunctionalityUsingVisitorPattern.After;

class Boss implements Visitable {

    private double totalSalesAmount;
    private int newCustomers;
    private double officeExpenses;

    Boss(double totalSalesAmount, int newCustomers, double officeExpenses) {
        this.totalSalesAmount = totalSalesAmount;
        this.newCustomers = newCustomers;
        this.officeExpenses = officeExpenses;
    }

    double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    int getNewCustomers() {
        return newCustomers;
    }

    double getOfficeExpenses() {
        return officeExpenses;
    }

    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
