package RefactoringTechniques.ComposingMethods.ExtractClass;


class Customer {

    private String firstName = "";
    private String lastName = "";
    private Address address = null;
    private Birthday birthday = null;

    private Customer(String firstName, String lastName, String street,
                    String city, String state, int postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new Address(street, city, state, postalCode);
    }

    private Customer(String firstName, String lastName,
                     Address address, Birthday birthday) {
        this.firstName = firstName;
        this.lastName = lastName ;
        this.address = address;
        this.birthday = birthday;
    }

    private String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        Address charliePuthAddress = new Address("123 Main St", "LA", "California", 50220);
        Birthday charliePuthBirthday = new Birthday( 7, 30, 1994);
        Customer charliePuth = new Customer("Charlie", "Puth", charliePuthAddress, charliePuthBirthday);

        // The positive of accessing fields through accessor methods is that
        // subclasses can override the way fields are accessed and the fields
        // can be protected. The negative is that the code is hard to read.

        System.out.println("Customer Name: " + charliePuth.getFirstName() + " " + charliePuth.getLastName());
        System.out.println("Address: " + charliePuth.address.getStreet() + " " + charliePuth.address.getCity()
                + " " + charliePuth.address.getState() + " " + charliePuth.address.getPostalCode());

        System.out.println("Customer Name: " + charliePuth.getFirstName() + " " + charliePuth.getLastName());
        System.out.println("Customer Address: " + charliePuth.address);
        System.out.println("Customer Birthday: " + charliePuth.birthday); // instead of using getters, use Birthday.toString()
    }
}
