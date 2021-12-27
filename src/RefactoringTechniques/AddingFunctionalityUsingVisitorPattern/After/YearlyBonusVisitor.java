package RefactoringTechniques.AddingFunctionalityUsingVisitorPattern.After;

class YearlyBonusVisitor implements Visitor {

    public double visit(SalesTrainee trainee) {
        System.out.println("Trainee's yearly bonus");
        double yearlyBonusPercentage;
        if (trainee.getSickDays() < 10 && trainee.getFailedTests() < 2) {
            yearlyBonusPercentage = 0.10;
        } else {
            yearlyBonusPercentage = 0.02;
        }

        return trainee.getSalary() * yearlyBonusPercentage;
    }

    public double visit(Salesman salesman) {
        System.out.println("Salesman's yearly bonus");
        double yearlyBonusPercentage;
        if (salesman.getTotalSalesAmount() > 100000 && salesman.getNewCustomers() > 50) {
            yearlyBonusPercentage = 0.12;
        } else {
            yearlyBonusPercentage = 0.04;
        }

        return salesman.getTotalSalesAmount() * yearlyBonusPercentage;
    }

    public double visit(Boss boss) {
        System.out.println("Boss's yearly bonus");
        double yearlyBonusPercentage;
        if (boss.getOfficeExpenses() < 50000 && boss.getNewCustomers() > 1000) {
            yearlyBonusPercentage = 0.15;
        } else {
            yearlyBonusPercentage = 0.04;
        }

        return boss.getTotalSalesAmount() * yearlyBonusPercentage;
    }
}
