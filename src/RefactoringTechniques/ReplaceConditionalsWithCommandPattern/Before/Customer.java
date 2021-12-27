package RefactoringTechniques.ReplaceConditionalsWithCommandPattern.Before;

class Customer {

    private int age;
    private boolean isMan;
    private double bill;

    public Customer(int age, boolean isMan, double bill) {
        this.age = age;
        this.isMan = isMan;
        this.bill = bill;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public void calculateBill() {
        double percentageDiscount = 0.0;
        if (age > 60) {
            percentageDiscount += 0.05;
        }

        if (!isMan) {
            percentageDiscount += 0.05;
        }

        // the problem is if I want to introduce a new customer type
        // i have to change the logic here
        // create new subclasses, etc.

        System.out.println("Bill Amount: $" + (bill - bill * percentageDiscount));
    }

    public static void main(String[] args) {
        Customer billSmith = new Customer(62, true, 12);
        billSmith.calculateBill();
    }
}
