package Concepts.Hard.LookupRules;

class Parent {

    int num = 1;
    static int statNum = 2;

    int getNum() {
        System.out.print("  Parent instance method: ");
        return num;
    }

    static int getStatNum() {
        System.out.print("  Parent static method: ");
        return statNum;
    }
}