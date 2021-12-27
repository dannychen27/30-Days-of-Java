package Constructs.Easy.Break;

public class Break {

    public static void main(String[] args) {
        // - We use break only inside loops (for, while) to exit out of the current loop
        // - We use continue only inside loops (for, while) to skip the current loop iteration

        // - If used improperly, break and continue can impair code readability
        //      - hidden traps in the middle of code
        // - If used properly, break and continue can enhance code readability
        //      - reduce nesting
        //      - act as preconditions at the beginning of code, etc.

        // Source: https://softwareengineering.stackexchange.com/questions/58237/are-break-and-continue-bad-programming-practices

        // Poor use of break
        int i = 0;
        while (true) {
            System.out.println(i);
            i++;
            if (i >= 10) {
                break; // This condition should really be in the while condition
            }
        }

        // can be replaced with loop condition in
        int j = 0;
        while (j < 10) {
            System.out.println(j);
            j++;
        }

        // Great use of break
        String java = "Beans";
        for (int k = 0; k < java.length(); k++) {
            if (java.charAt(k) == 'n') {
                break;  // stop at the "n"
            }
            System.out.println("k: " + k + " letter: " + java.charAt(k));
        }
    }
}
