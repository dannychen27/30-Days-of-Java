package Constructs.Medium.Super;

public class Super {

    public static void main(String[] args) {
        // - super lets you reference a superclass.
        // - super.variable lets you reference a superclass instance variable
        // - super() lets you call the superclass's constructor
        // - super.method() lets you call the superclass's method instead

        B b = new B();
        System.out.println(b.getValue()); // 5
        b.sayHello(); // Hello
    }
}

class A {
    int value;

    A() {
        value = 5;
    }

    void sayHello() {
        System.out.println("Hello");
    }
}

class B extends A {

    B() {
        super();
    }

    public int getValue() {
        return super.value;
    }

    public void sayHello() {
        super.sayHello();
    }
}