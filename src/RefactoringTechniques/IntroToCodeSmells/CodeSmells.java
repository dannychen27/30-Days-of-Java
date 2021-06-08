package RefactoringTechniques.IntroToCodeSmells;

public class CodeSmells {

    // - code smell = a characteristic of code that indicates a larger design issue
    // - bad design is unclear, complicated, or duplication


    // - examples of code smells:

    // obvious code smells
    //      - duplicated code
    //          -- identical or very similar code
    //      - long methods
    //          -- poorly modularized methods, or
    //          -- multiply-responsible methods.
    //      - unnecessary or misleading code
    //          -- comments become stale over time
    //          -- developer relies too heavily on comments, instead of self documenting method names

    // object oriented abusers
    //      - complex conditional statements
    //          -- long if/switch statements
    //          -- violates OCP
    //          -- hard to extend a system
    //      - primitive obsession
    //          -- overusing primitives (int, double, boolean) and underusing classes is contrary to OOP
    //      - indecent exposure
    //          -- methods and classes are poorly encapsulated (more public than needed)
    //      - lazy classes
    //          -- classes that have so few responsibilities that they have little reason to exist, they
    //          simply waste memory.
    //          -- can consolidate them into a larger class
    //      - large classes
    //          -- classes that have so many responsibilities that they are difficult to understand and are
    //          tightly coupled
    //          -- decompose the large class into smaller singly-responsible classes
    //      - switch statements
    //          -- restricts extensibility by hardcoding options
    //          -- replace with polymorphism

    // other
    //      - solution sprawl
    //          --
    //      - alternative classes with different interfaces
    //          -- different interface, same classes themselves
    //          -- better to combine the two interfaces into one
    //      - combinatorial explosions
    //          -- use many specific methods to perform a task that could be done with only
    //          one method that is generalized
    //      - oddball solutions
    //          -- solve the same problem in many different ways
    //          -- instead, use a similar solution to the same types of problems
}
