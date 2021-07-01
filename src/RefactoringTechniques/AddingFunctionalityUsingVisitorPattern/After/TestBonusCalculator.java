package RefactoringTechniques.AddingFunctionalityUsingVisitorPattern.After;

public class TestBonusCalculator {

    public static void main(String[] args) {
        // We can have completely different calculations performed
        // on completely different objects just by defining a
        // new concrete Visitor
        YearlyBonusVisitor yearlyBonusCalculator = new YearlyBonusVisitor();
        SalesTrainee bradTrainee = new SalesTrainee(5, 1, 20000);
        Salesman tomSalesman = new Salesman(150000, 62);
        Boss rossBoss = new Boss(1000000, 1200, 40000);

        System.out.println("YEARLY BONUS");
        System.out.println(bradTrainee.accept(yearlyBonusCalculator));
        System.out.println(tomSalesman.accept(yearlyBonusCalculator));
        System.out.println(rossBoss.accept(yearlyBonusCalculator));

        QuarterlyBonusVisitor quarterlyBonusCalculator = new QuarterlyBonusVisitor();
        bradTrainee = new SalesTrainee(1, 0, 20000);
        tomSalesman = new Salesman(30000, 22);
        rossBoss = new Boss(200000, 300, 11000);

        System.out.println("\nQUARTERLY BONUS");
        System.out.println(bradTrainee.accept(quarterlyBonusCalculator));
        System.out.println(tomSalesman.accept(quarterlyBonusCalculator));
        System.out.println(rossBoss.accept(quarterlyBonusCalculator));
    }
}
