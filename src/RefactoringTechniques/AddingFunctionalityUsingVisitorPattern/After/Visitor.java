package RefactoringTechniques.AddingFunctionalityUsingVisitorPattern.After;

// Each concrete Visitor type will implement the Visitor interface.
// Here we define every instance of method overloading needed.

interface Visitor {

    double visit(SalesTrainee trainee);
    double visit(Salesman salesman);
    double visit(Boss boss);
}
