package RefactoringTechniques.AddingFunctionalityUsingVisitorPattern.After;

class Salesman implements Visitable {

    private double totalSalesAmount;
    private int newCustomers;

    Salesman(double totalSalesAmount, int newCustomers) {
        this.totalSalesAmount = totalSalesAmount;
        this.newCustomers = newCustomers;
    }

    double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    int getNewCustomers() {
        return newCustomers;
    }

    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
