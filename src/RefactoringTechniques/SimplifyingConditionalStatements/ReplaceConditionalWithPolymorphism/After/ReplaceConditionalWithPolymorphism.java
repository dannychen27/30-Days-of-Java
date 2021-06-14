package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithPolymorphism.After;

public class ReplaceConditionalWithPolymorphism {

    public static void main(String[] args) {
        // conditional statements choose behaviour depending on the type of object
        // polymorphism = dynamically adapt behaviour depending on type of object

        Animal rex = new Dog("Woof");
        Animal sophie = new Cat("Meow");
        System.out.println(rex.getSound());
        System.out.println(sophie.getSound());
    }
}
