package OOPDesignPrinciples.Encapsulation;

public class EncapsulationBefore {

    public static void main(String[] args) {
        // - One way to set attributes of a class is outside the class.
        // - It violates encapsulation (the ability of hiding the inner implementation details
        // to reduce programmer cognitive load). Objects and attributes can
        // get disorganized over time as our program grows.
        // - Any future attribute changes you make could break your Diffuser class.
        Diffuser diffuser = new Diffuser();
        diffuser.name = "Diffuser";
        diffuser.onStatus = false;
        System.out.println(diffuser.onStatus); // false
        System.out.println(diffuser.name); // Diffuser

        diffuser.onStatus = true;
        diffuser.name = "DiffuserUpdated";
        System.out.println(diffuser.onStatus); // true
        System.out.println(diffuser.name); // DiffuserUpdated
    }
}
