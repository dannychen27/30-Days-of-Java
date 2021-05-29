package JavaConcepts.Generics;

import java.util.ArrayList;

public class Generics {

    public static void main(String[] args) {
        // Need to rewatch: https://www.youtube.com/watch?v=fIkJNhi78fc&list=PL_c9BZzLwBRJOmvlnRQpnZS7ZpEvtwkXb&index=25
        // - Generic types let us use general types instead of specific types
        // - most common letters for generic types: E e, T t, where their types are unknown

        // without generics (errors are found in runtime)
        // ArrayList messages = new ArrayList();
        // messages.add(5);
        // messages.add("hello");
        // System.out.println((String) messages.get(0));

        // with generics (errors are found in compile time)
        ArrayList<String> messages2 = new ArrayList<>();
        // messages2.add(5); // only strings are allowed
        messages2.add("hello");
        System.out.println((String) messages2.get(0)); // hello

        Item<String> item = new Item<>();
        item.setX("Hello");
        String s2 = item.getX();
        System.out.println(s2); // Hello

        Pair<String, Integer> pair = new Pair<>();
        pair.setX("hello");
        String s3 = pair.getX();
        pair.setY(5);
        Integer i3 = pair.getY();
        System.out.println(s3); // Hello
        System.out.println(i3); // 5

        ArrayList<Person> people = new ArrayList<>();
        Admin a = new Admin();
        people.add(a);
        doSomething(a);  // JavaConcepts.Generics.Admin@3c1

        // inheritance/polymorphism doesn't work for generics if
        // aPublicMethod has signature static void aPublicMethod(ArrayList<Person> peeps)
        // (13:12 type to a derived classes), even if Admin inherits person
        // ArrayList<Admin> admins = new ArrayList<>();
        // admins.add(a);
        // aPublicMethod(admins);

        // A temporary fix:
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(a);
        ArrayList<Person> adminsP = new ArrayList<>();
        for (Admin admin : admins) {
             adminsP.add((Person) admin);
        }
        doSomething(adminsP); // [JavaConcepts.Generics.Admin@3c1]
    }

    static void doSomething(Person p) {
        System.out.println(p);
    }

    static void doSomething(ArrayList<Person> peeps) {
        System.out.println(peeps);
    }
}
