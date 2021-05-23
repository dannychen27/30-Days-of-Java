package JavaConstructs.ConditionalStatements;

public class ConditionalStatements {

    public static void main(String[] args) {
        // Dependent conditions
        int x = 0;
        if (x < 0) {
            System.out.println(x + " is negative");
        } else if (x > 0) {
            System.out.println(x + " is positive");
        } else {
            System.out.println(x + " is neutral");
        }

        // Independent conditions
        int score1 = 95;
        int score2 = 75;
        int score3 = 80;

        if (score1 >= 80) {  // this condition is true
            System.out.println("Person 1 scored: " + score1);
        }

        if (score2 >= 80) {  // this condition is false
            System.out.println("Person 2 scored: " + score2);
        }

        if (score3 >= 80) {  // this condition is true
            System.out.println("Person 3 scored: " + score3);
        }
    }
}
