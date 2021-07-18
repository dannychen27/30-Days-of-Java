package InterviewProblems.HashMapProblems.IceCreamParlor;

public class IceCreamParlorNaive {

    // source: https://www.youtube.com/watch?v=Ifwf3DBN1sc&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=2

    // Given a menu of ice cream flavours, and a certain amount of money, and we want exactly 2
    // distinct ice cream flavours (even if they're the same price).
    //
    // Return the indices of the items we want to buy (smallest index first to break ties),
    // not just their values.

    // naive approach: walk through all pairs of ice cream flavours
    // time O(n ^ 2)
    // space O(1)

    // TODO: Maybe try this problem again, but represent the menu using a HashMap like this one:
    // TODO: Then return a list of Strings for ice cream flavours instead of list of indices in an int array.
    //
    // HashMap<String, Integer> iceCreamFlavoursToPrices = new HashMap<>();
    // iceCreamFlavoursToPrices.put("Strawberry", 2);
    // iceCreamFlavoursToPrices.put("Blueberry", 7);
    // iceCreamFlavoursToPrices.put("Nutella", 13);
    // iceCreamFlavoursToPrices.put("Vanilla", 5);
    // iceCreamFlavoursToPrices.put("Banana", 5);
    // iceCreamFlavoursToPrices.put("Bubblegum", 5);
    // iceCreamFlavoursToPrices.put("Chocolate", 5);

    public int[] findChoices(int[] menuPrices, int budget) {
        for (int i = 0; i < menuPrices.length; i++) {
            for (int j = i + 1; j < menuPrices.length; j++) {
                if (menuPrices[i] + menuPrices[j] == budget) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
