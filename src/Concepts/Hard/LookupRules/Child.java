package Concepts.Hard.LookupRules;

class Child extends Parent {

    int num = 10;
    static int statNum = 20;

    int getNum() {
        System.out.print("  Child instance method: ");
        return num;
    }

    static int getStatNum() {
        System.out.print("  Child static method: ");
        return statNum;
    }
}