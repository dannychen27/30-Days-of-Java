package RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithFactoryMethods;

public class ReplaceConstructorsWithFactoryMethods {
    // source:
    // - https://www.youtube.com/watch?v=NhFmQl1FA5Y&list=PLGLfVvz_LVvSuz6NuHAzpM52qKM6bPlCV&index=5
    // code refactoring part 5

    // - Create a class called Athlete with subclasses for Gold, Silver, and Bronze winners.
    // - Make it so once an Athlete receives a medal, no other Athletes can be assigned to that
    // medal's subclass
    // - the program isn't allowed to contain conditional statements

    // Solution: replace the constructors with a factory method!
    // - a factory method lets you create objects without having to specify the exact class that will be created
}

