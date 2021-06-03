package OOPDesignPrinciples.Encapsulation;

public class EncapsulationAfter {

    public static void main(String[] args) {
        // - Instead of accessing attributes directly, we can use getter and setter methods
        // to hide implementation details of the Diffuser class.
        // - Encapsulate what varies! With encapsulation you're free to change the implementation of the
        // Diffuser class easily without affecting the interface of the Diffuser class (how to call its methods).
        Diffuser diffuser = new Diffuser("Diffuser");
        System.out.println(diffuser.getOnStatus()); // false
        System.out.println(diffuser.getName()); // Diffuser

        diffuser.setOn(true);
        diffuser.setName("DiffuserUpdated");
        System.out.println(diffuser.getOnStatus()); // true
        System.out.println(diffuser.getName()); // DiffuserUpdated
    }
}
