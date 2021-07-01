package RefactoringTechniques.AddingFunctionalityUsingVisitorPattern.After;

class QuarterlyBonusVisitor implements Visitor {

    public double visit(SalesTrainee trainee) {
        System.out.println("Trainee's yearly bonus");
        double quarterlyBonusPercentage;
        if (trainee.getSickDays() < 2 && trainee.getFailedTests() < 1) {
            quarterlyBonusPercentage = 0.01;
        } else {
            quarterlyBonusPercentage = 0.005;
        }

        return trainee.getSalary() * quarterlyBonusPercentage;
    }

    public double visit(Salesman salesman) {
        System.out.println("Salesman's yearly bonus");
        double quarterlyBonusPercentage;
        if (salesman.getTotalSalesAmount() > 25000 && salesman.getNewCustomers() > 20) {
            quarterlyBonusPercentage = 0.03;
        } else {
            quarterlyBonusPercentage = 0.01;
        }

        return salesman.getTotalSalesAmount() * quarterlyBonusPercentage;
    }

    public double visit(Boss boss) {
        System.out.println("Boss's yearly bonus");
        double quarterlyBonusPercentage;
        if (boss.getOfficeExpenses() < 12000 && boss.getNewCustomers() > 250) {
            quarterlyBonusPercentage = 0.0375;
        } else {
            quarterlyBonusPercentage = 0.01;
        }

        return boss.getTotalSalesAmount() * quarterlyBonusPercentage;
    }
}
