package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithPolymorphism.Before;

public class ReplaceConditionalWithPolymorphism {

    public static void main(String[] args) {
        // conditional statements choose behaviour depending on the type of object
        // polymorphism = dynamically adapt an object's behaviour depending on type of object calling this method
        String doggy = "Dog";
        String kitty = "Cat";
        makeSound(doggy);
        makeSound(kitty);
    }

    static void makeSound(String animal) {
        switch (animal) {
            case "Dog":
                System.out.println("Woof");
                break;
            case "Cat":
                System.out.println("Meow");
                break;
            default:
                throw new RuntimeException("I don't know that animal.");
        }
    }
}
