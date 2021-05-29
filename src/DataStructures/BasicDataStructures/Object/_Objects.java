package DataStructures.BasicDataStructures.Object;

public class _Objects {

    public static void main(String[] args) {
        Person rossLynch = new Person("rosslynch@hotmail.com", "Ross Lynch");
        Person grantGustin = new Person("grantgustin@hotmail.com", "Grant Gustin");
        Person grantGustin2 = new Person("grantgustin@hotmail.com", "Grant Gustin");

        // By default, Object.equals() or == compares memory addresses for equality.

        // Two objects that are equal must have the same hashcode.
        // Otherwise, their hash codes can be different.
        System.out.println(rossLynch.equals(grantGustin)); // false
        System.out.println(rossLynch.hashCode()); // 1772076068
        System.out.println(grantGustin.hashCode());  // -2020128654

        System.out.println(grantGustin.equals(grantGustin2)); // true
        System.out.println(grantGustin.hashCode()); // -2020128654
        System.out.println(grantGustin2.hashCode()); // -2020128654
    }
}
