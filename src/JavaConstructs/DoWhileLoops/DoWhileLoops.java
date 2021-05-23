package JavaConstructs.DoWhileLoops;

public class DoWhileLoops {

    public static void main(String[] args) {
        // - A do while loop is a while loop that must run at least one before stopping
        // - A do while loop is good for e.g. prompting user at least once, showing a menu at least once
        // - A while loop must run at least 0 times before stopping (e.g. while condition is immediately false).

        // When while loops and do-while loops are equivalent
        int i = 0;
        while (i < 4) {
            System.out.println(i);
            i++;
        }
        System.out.println();

        int j = 0;
        do {
            System.out.println(j);
            j++;
        } while (j < 4);
        System.out.println();

        // When while loops and do-while loops are different
        int numIterations = 0;
        // while (false) {
        //     numIterations++;
        // }
        System.out.println("A while loop runs at least " + numIterations + " iterations");

        numIterations = 0;
        do {
            numIterations++;
        } while (false);
        System.out.println("A do while loop runs at least " + numIterations + " iterations");
    }
}
