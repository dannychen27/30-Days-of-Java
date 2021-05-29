package Constructs.Easy.UserInput;

import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {
        // setting up the scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a diffuser scent: ");

        // accepting user input
        String diffuserScent = scanner.next();
        System.out.println("Your favourite diffuser scent is: " + diffuserScent);
    }
}
