package InterviewProblems.BinarySearch.IceCreamParlor;

import java.util.Arrays;

public class IceCreamParlorBinarySearch {

    // binary search: sort menu, and find ice cream flavours using binary search
    // we can either...
    // - create a MenuItem struct:
    // class MenuItem {
    //      int cost;
    //      int index;
    // }
    // - create copy of menu <-- easier

    // binary search approach:
    // time O(n log n)
    // space O(n)

    // Finds the indices of two items on the menu that allow us to spend all our money.
    public int[] findChoices(int[] menuPrices, int budget) {
        int[] sortedMenuPrices = menuPrices.clone();
        Arrays.sort(sortedMenuPrices);

        for (int i = 0; i < sortedMenuPrices.length; i++) {
            int complement = budget - sortedMenuPrices[i];
            // if item not found, binarySearch() doesn't return -1, it returns where the
            // value where the item would have been contained
            int location = Arrays.binarySearch(sortedMenuPrices, i + 1, sortedMenuPrices.length, complement);
            if (location >= 0 && location < sortedMenuPrices.length && sortedMenuPrices[location] == complement) {
                return getIndicesFromValues(menuPrices, sortedMenuPrices[i], complement);
            }
        }
        return new int[] {-1, -1};
    }

    private int[] getIndicesFromValues(int[] menuPrices, int value1, int value2) {
        int index1 = indexOf(menuPrices, value1, -1);
        int index2 = indexOf(menuPrices, value2, index1);
        return new int[] {Math.min(index1, index2), Math.max(index1, index2)};
    }

    private int indexOf(int[] menuPrices, int value, int excludeThis) {
        for (int i = 0; i < menuPrices.length; i++) {
            if (menuPrices[i] == value && i != excludeThis) {
                return i;
            }
        }
        return -1;
    }
}
