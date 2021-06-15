package InterviewProblems.HashMapProblems.IceCreamParlor;

import java.util.Arrays;

public class IceCreamParlorNaive {

    public static void main(String[] args) {
        // source: https://www.youtube.com/watch?v=Ifwf3DBN1sc&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=2

        // Given a menu of ice cream flavours, and a certain amount of money, and we want exactly 2
        // distinct ice cream flavours (even if they're the same price).
        //
        // Return the indices of the items we want to buy (smallest index first to break ties),
        // not just their values.

        // naive approach: walk through all pairs of ice cream flavours
        // time O(n ^ 2)
        // space O(1)
        int[] menuPrices = {2, 7, 13, 5, 4, 13, 5};
        System.out.println(Arrays.toString(findChoices(menuPrices, 10))); // [3, 6]
    }

    private static int[] findChoices(int[] menuPrices, int budget) {
        int[] choices = {-1, -1};
        for (int i = 0; i < menuPrices.length; i++) {
            for (int j = i + 1; j < menuPrices.length; j++) {
                if (menuPrices[i] + menuPrices[j] == budget) {
                    choices[0] = i;
                    choices[1] = j;
                    break;
                }
            }
        }
        return choices;
    }
}
