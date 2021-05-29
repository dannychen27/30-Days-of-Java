package JavaConcepts.AccessModifiers.Package3;

import JavaConcepts.AccessModifiers.Package4.Class7;

public class Class6 {

    public Class6() {
        System.out.println("I am a public class!");
    }

    public static void main(String[] args) {
        Class6 class6 = new Class6();  // I am a public class!
        Class7 class7 = new Class7();  // I am a protected class!
        Class8 class8 = new Class8();  // I am a default class!
        // Class9 class9 = new Class9();  // I am a private class!
    }
}

// Protected classes are apparently not allowed outside of a class.
// They are only allowed inside of other classes.
//
// source 1: https://stackoverflow.com/questions/3869556/why-can-a-class-not-be-defined-as-protected
// source 2: https://stackoverflow.com/questions/2534733/how-to-protect-classes-so-they-are-not-visible-outside-their-package
//
// protected class Class11 extends Class6 {
//
//     protected Class11() {
//         System.out.println("I am a protected class!");
//     }
// }
