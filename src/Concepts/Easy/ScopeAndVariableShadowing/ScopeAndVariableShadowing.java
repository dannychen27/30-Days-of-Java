package Concepts.Easy.ScopeAndVariableShadowing;

public class ScopeAndVariableShadowing {
    int x = 6; // highest scope, since you cannot have code outside of classes

    public void doSomething() {
        System.out.println("Class scope: The value of x is " + x);
        // System.out.println("The value of y is " + y); // y is not in scope
    }

    public static void main(String[] args) {
        // Scope -- determines where variables are accessible
        // Shadowing -- you can take advantage of scope to use the same variable names.
        // java finds the closest-scoped variable as the value of a variable,
        // when the same variable name is used!
        // variable search process as soon as a variable is added or removed from program
        // lowest scope first --> ... --> highest scope last --> variable not found

        ScopeAndVariableShadowing scope = new ScopeAndVariableShadowing();
        scope.doSomething();

        int x = 5;
        System.out.println("Method scope: The value of x is " + x);

        int y = 5;
        System.out.println("Method scope: The value of y is " + y);

        {
            x = 4; // lowest scope
            System.out.println("Block scope: The value of x is " + x);
            System.out.println("Block scope: The value of y is " + y);

            int z = 4;
            System.out.println("Block scope: The value of z is " + z);
        }
    }
}
