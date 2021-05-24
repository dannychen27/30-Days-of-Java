package JavaConstructs.StringBuilders;

public class StringBuilders {

    public static void main(String[] args) {
        // The difference between a String and a StringBuilder is that
        // a String is immutable (like a fixed array) whereas
        // a StringBuilder is mutable (like a dynamic array with capacity).

        // Strings
        String message1 = "Hello";
        // message1.insert(2, "EE");  // This does not work, only replace* methods work.
        System.out.println(message1);

        // StringBuilders
        StringBuilder message2 = new StringBuilder("Hello");
        message2.insert(2, "EE");
        System.out.println(message2);
    }
}
