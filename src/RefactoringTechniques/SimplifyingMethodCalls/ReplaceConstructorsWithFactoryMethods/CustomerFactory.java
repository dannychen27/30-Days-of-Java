package RefactoringTechniques.SimplifyingMethodCalls.ReplaceConstructorsWithFactoryMethods;

import java.lang.reflect.InvocationTargetException;

class CustomerFactory {

    public Customer getCustomer(int customerType) {
        // This is a valid factory, except it breaks the rule of "no conditional statements"
        switch (customerType) {
            case 2:
                return new Premier();
            case 1:
                return new Valued();
            case 0:
                return new Deadbeat();
            default:
                throw new IllegalArgumentException("Invalid Customer Type");
        }
    }

    Customer getCustomer(String customerName) {
        try {
            return (Customer) Class.forName(customerName).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException |
                InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Invalid Customer Type");
            return null;
        }
    }
}
