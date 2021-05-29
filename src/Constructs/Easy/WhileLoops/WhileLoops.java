package JavaConstructs.Easy.WhileLoops;

public class WhileLoops {

    public static void main(String[] args) {
        // - While loops are indefinite (infinite), unlike for loops which are definite (finite)
        // - All for loops can be rewritten as while loops, but not vice versa

        int i = 0;  // initialize
        while (i < 4) {  // condition
            System.out.println(i);  // 0, 1, 2, 3
            i++;  // update
        }
    }
}
