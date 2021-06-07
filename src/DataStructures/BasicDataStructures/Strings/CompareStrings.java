package DataStructures.BasicDataStructures.Strings;

public class CompareStrings {

    public static void main(String[] args) {
        // String.equals() checks for value equality of strings, regardless of unicode value.
         String message = "I like oranges";
         String message2 = "I like strawberries";
         String message3 = message2;  // make a copy of message2
         System.out.println(message.equals(message2)); // false -- strings have different values
         System.out.println(message.equals(message3)); // false -- strings have different values
         System.out.println(message2.equals(message3)); // true -- string have same values

         // String == checks for object equality (same memory address), regardless of unicode value
         System.out.println(message == message2); // false -- strings have different memory addresses
         System.out.println(message == message3); // false -- strings have different memory addresses
         System.out.println(message2 == message3); // true -- strings have same memory addresses

        // compareTo compares string in lexicographic order (unicode value of each character in the string)
        // compareToIgnoreCase does the same, but ignores casing.
        // source: https://www.w3schools.com/java/ref_string_compareto.asp compareTo and compareToIgnoreCase
        System.out.println(message.compareTo(message3)); // -4 (fewer characters)
        System.out.println(message3.compareToIgnoreCase(message)); // 4 (more characters)
        System.out.println(message2.compareTo(message3)); // 0

        // Notice that new String() is a less efficient alternative to the direct string initialization
        String message4 = "I like oranges";
        String message5 = new String("I like oranges");
        System.out.println(message4.equals(message5)); // true -- strings have same value
        System.out.println(message4 == message5);      // false -- strings have different memory addresses
    }
}
