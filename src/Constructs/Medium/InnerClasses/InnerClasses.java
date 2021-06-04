package Constructs.Medium.InnerClasses;

public class InnerClasses {

    public static void main(String[] args) {
        // source: https://www.w3schools.com/java/java_inner_classes.asp
        // - an inner class is a nested class (a class inside of another class)
        // - inner classes lets you group together related classes (increases cohesion)
        OuterClass myOuter = new OuterClass();
        OuterClass.InnerClass myInner = myOuter.new InnerClass(); // use dot notation to refer to inner classes.
        // OuterClass.PrivateInnerClass myPrivateInner = myOuter.new PrivateInnerClass(); // This is not allowed
        OuterClass.StaticInnerClass myStaticInner = new OuterClass.StaticInnerClass();

        System.out.println(myOuter.w); // 10
        System.out.println(myInner.x); // 5
        // System.out.println(myOtherInner.y); // This is also not allowed.
        System.out.println(myStaticInner.z); // 7

        // - inner classes can always access all fields and methods of their corresponding outer classes
        System.out.println(myInner.getW()); // 10
    }
}

class OuterClass {
    int w = 10;

    class InnerClass {
        int x = 5;

        int getW() {
            return w;
        }
    }

    // An inner class can be private or protected.
    // If you don't want outside objects to access the inner class, declare the class as private.
    private class PrivateInnerClass {
        int y = 6;
    }

    // We can access static inner classes without creating an instance of the outer class.
    static class StaticInnerClass {
        int z = 7;
    }
}