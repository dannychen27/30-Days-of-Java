package RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithFactoryMethods;

class Customer {

    private String customerRating;
    static final int PREMIER = 2;
    static final int VALUED = 1;
    static final int DEADBEAT = 0;

    private String getCustomerRating() {
        return customerRating;
    }

    void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    public static void main(String[] args) {
        CustomerFactory customerFactory = new CustomerFactory();
        Customer goodCustomer = customerFactory.getCustomer("RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithFactoryMethods.Premier");
        System.out.println("Customer Rating: " + goodCustomer.getCustomerRating());
    }
}
