package RefactoringTechniques.ReplaceConditionalsWithCommandPattern.After;

class CustomerTypePicker {

    // you can think of these as buttons on a cash register

    public static BillPayer getWomanOver60() {
        return new WomanOver60();
    }

    public static BillPayer getManOver60() {
        return new ManOver60();
    }

    public static BillPayer getWomanUnder60() {
        return new WomanUnder60();
    }

    public static BillPayer getManUnder60() {
        return new ManUnder60();
    }
}
