package RefactoringTechniques.ComposingMethods.ExtractClass;

class Address {

    private String street = "";
    private String city = "";
    private String state = "";
    private int postalCode = 0;

    Address(String street, String city, String state, int postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String toString() {
        return getStreet() + " " + getCity() + " " + getState() + " " + getPostalCode();
    }

    String getStreet() {
        return street;
    }

    String getCity() {
        return city;
    }

    String getState() {
        return state;
    }

    int getPostalCode() {
        return postalCode;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setState(String state) {
        this.state = state;
    }

    private void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
