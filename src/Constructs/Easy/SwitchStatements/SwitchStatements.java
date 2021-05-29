package JavaConstructs.Easy.SwitchStatements;

public class SwitchStatements {

    public static void main(String[] args) {
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Unknown date");
                break;
        }

        // Q1: What's the difference between switch statements and if-else if-else?
        // A1: Switch statements must have only one expression and multiple possible branches.
        // If-else statements can have multiple expressions and multiple possible branches.
    }
}
