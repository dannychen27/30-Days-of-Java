package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithStrategyPattern.After;

class ReplaceConditionalWithStrategyPattern {

    public static void main(String[] args) {
        Employee salesman = new Salesman(15000.00, new Bonus15Percent());
        Employee secretary = new Secretary(25000.00);

        System.out.println("The salesman gets paid: " + salesman.getPay());
        System.out.println("The secretary gets paid: " + secretary.getPay());

        secretary.setBonusOption(new Bonus15Percent());  // I can change paymentMethod on the fly!
        System.out.println("The secretary gets paid: " + secretary.getPay());

        Employee salesTrainee = new Salesman(15000.00, new NoBonus());
        System.out.println("The salesman trainee gets paid: " + salesTrainee.getPay());

        salesTrainee.setBonusOption(new Bonus20Percent());
        System.out.println("The salesman trainee gets paid: " + salesTrainee.getPay());
    }
}
