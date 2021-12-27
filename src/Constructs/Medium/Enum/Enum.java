package Constructs.Medium.Enum;



public class Enum {

    private DiffuserScent favouriteDiffuserScent;

    private Enum(DiffuserScent favouriteDiffuserScent) {
        this.favouriteDiffuserScent = favouriteDiffuserScent;
    }

    public DiffuserScent getFavouriteDiffuserScent() {
        return favouriteDiffuserScent;
    }

    public static void main(String[] args) {
        // sources:
        // https://www.w3schools.com/java/java_enums.asp basic syntax
        // https://www.geeksforgeeks.org/enum-in-java/ switch statements

        // - Enumerations are a special class that allow us to define a list of possible constant
        // (public static final) values
        //      -- public: duh.
        //      -- static: we want Class.ENUM
        //      -- final: no child enums allowed
        // - Enumerate = "specifically listed"
        // - like classes, they have attributes, methods, and constructors
        // - all enums extend the java.lang.Enum class
        // - use them to represent values that you know aren't going to change at compile time, like month days,
        // days, colors, deck of cards, etc.
        // - enums cannot be used to create objects, and it cannot extend other classes
        // (but it can implement interfaces).
        // - They throw compile time errors instead of run time errors, and are case sensitive.

        Enum e = new Enum(DiffuserScent.LAVENDER);
        System.out.println(e.getFavouriteDiffuserScent()); // Lavender
        e.favouriteDiffuserScent.printValues();
        // Lavender
        // Sweet Orange
        // Lemongrass
        // Peppermint
        // Eucalyptus
        // Tea Tree Oil
        System.out.println(e.favouriteDiffuserScent.ordinal()); // 0

        // return a object DiffuserScent with the given constant
        System.out.println(DiffuserScent.valueOf("LAVENDER")); // Lavender
    }
}
