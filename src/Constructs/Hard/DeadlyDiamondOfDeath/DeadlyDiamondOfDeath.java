package Constructs.Hard.DeadlyDiamondOfDeath;

public class DeadlyDiamondOfDeath {

    public static void main(String[] args) {
        // deadly diamond of death:
        // - since all classes without a parent are children of Object,
        // a class can only have at most one superclass.
        // - otherwise, with two superclasses, it's ambiguous which methods and
        // fields you'd inherit from? the first or the second one?
        // - interfaces are a sort of "hacky" workaround for a lack of multiple inheritance
    }
}

class A {

}

class B extends A {

}

class C extends A {

}

// This is not allowed: "class cannot extend multiple superclasses"
// class D extends B, C {
//
// }