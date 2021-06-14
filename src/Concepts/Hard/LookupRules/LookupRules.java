package Concepts.Hard.LookupRules;

public class LookupRules {

    public static void main(String[] args) {
        // - we use lookup rules when the subclass and superclass have different
        // copies of the same copies of the same variable:
        //      e.g. List<String> names = new ArrayList<>();
        // or when the subclass and super class have methods with the same signatures
        //      e.g. public ArrayList<String> hello(List<String> names) { ... }
        // - lookup rule summary:
        //      - instance methods = override (use implementation from Child)
        //      - instance variables = shadow (use value from Parent)
        //      - static methods = shadow (use implementation from Parent)
        //      - static variables = shadow (use value from Parent)
        demonstrateLookupRules();
    }

    private static void demonstrateLookupRules() {
        // source: https://github.com/pgries/LookupRules/tree/master/src/lookup
        Parent parentParent = new Parent();
        Child childChild = new Child();
        Parent parentChild = new Child();

        // Look up Rules:
        // 1. Use the type of the reference when looking up an instance variable,
        //    static variable, or static method.
        // 2. Use the type of the object when looking up an instance method.

        // instance methods = override (use implementation from Child -- RHS of the assignment statement)
        System.out.println("Instance methods");
        System.out.println("----------------");
        System.out.println("Parent ref->Parent obj");
        System.out.println(parentParent.getNum()); // 1
        System.out.println("Child ref –> Child obj");
        System.out.println(childChild.getNum()); // 10
        System.out.println("Parent ref-> Child obj");
        System.out.println(parentChild.getNum()); // 10 (instead of 1)
        System.out.println();

        // static methods = shadow (use implementation from Parent -- LHS of the assignment statement)
        System.out.println("Static methods");
        System.out.println("--------------");
        System.out.println("Parent ref->Parent obj");
        System.out.println(parentParent.getStatNum()); // 2
        System.out.println("Child ref –> Child obj");
        System.out.println(childChild.getStatNum()); // 20
        System.out.println("Parent ref-> Child obj");
        System.out.println(parentChild.getStatNum()); // 2
        System.out.println();

        // instance variables = shadow (use value from Parent -- LHS of the assignment statement)
        System.out.println("Instance variables");
        System.out.println("------------------");
        System.out.println("Parent ref->Parent obj " + parentParent.num); // 1
        System.out.println("Child ref –> Child obj " + childChild.num); // 10
        System.out.println("Parent ref-> Child obj " + parentChild.num); // 1
        System.out.println();

        // static variables = shadow (use value from Parent -- LHS of the assignment statement)
        System.out.println("Static variables");
        System.out.println("----------------");
        System.out.println("Parent ref->Parent obj " + parentParent.statNum); // 2
        System.out.println("Child ref –> Child obj " + childChild.statNum); // 20
        System.out.println("Parent ref-> Child obj " + parentChild.statNum); // 2
        System.out.println();

        // When do you cast?
        Child obj4 = (Child) parentChild; // need to cast
        Child obj5 = childChild; // no need to cast
    }
}
