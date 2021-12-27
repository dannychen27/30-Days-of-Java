package RefactoringTechniques.AddingFunctionalityUsingVisitorPattern.After;

// Allows the Visitor to pass in an object so the right calculations are done
// depending on the object type accept() is in each employee object.

// Those employee objects then pass an object of their specific type to a
// concrete Visitor. The concrete Visitors contain a method visit() that is
// overloaded to handle each of the employee types and can then perform
// different calculations based on the employee type.


interface Visitable {

    double accept(Visitor visitor);
}
