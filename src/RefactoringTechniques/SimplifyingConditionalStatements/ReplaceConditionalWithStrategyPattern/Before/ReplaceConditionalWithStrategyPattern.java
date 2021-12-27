package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithStrategyPattern.Before;

public class ReplaceConditionalWithStrategyPattern {

    public static void main(String[] args) {
        // strategy = how to do something
        // we want different strategies for paying various employees.
        // we use conditional logic to determine which payment algorithm to use.

        // What if i want a new kind of employee whose pay structure isn't a bonus?
        // e.g. commissioned, pension, bond, stocks, etc.

        // strategy pattern = lets you dynamically change algorithms used by objects at
        // runtime instead of compile time
        // eliminate conditionals, build subclasses for each algorithm.
        // better yet, use an interface because it further reduces coupling.
        Employee salesman = new Employee(15000.00, true, 0.20);
        Employee secretary = new Employee(20000.00, false);
        Employee salesTrainee = new Employee(15000.00, false);
        System.out.println("The salesman gets paid: " + salesman.getSalary());
        System.out.println("The secretary gets paid: " + secretary.getSalary());
        System.out.println("The salesman trainee gets paid: " + salesTrainee.getSalary());
    }
}
