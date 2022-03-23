package InterviewProblems.Arrays.CanPlaceFlower;

public class CanPlaceFlower {

    // Let n = the length of the flowerbed.
    // Time: O(n)
    // --> We must traverse through the flowerbed once.
    // Space: O(n)
    // --> We allocate an extra array with a 0 in front and a 0 at the back.

    public static void main(String[] args) {
        CanPlaceFlower canPlaceFlower = new CanPlaceFlower();

        // Input: flowerbed = [1, 0, 1], numFlowersToPlace = 1
        // Output: false
        int[] flowerbed1 = {1, 0, 1};
        boolean result1 = canPlaceFlower.canPlaceFlowers(flowerbed1, 1);
        System.out.println(result1);  // false

        // Input: flowerbed = [1, 0, 0, 1], numFlowersToPlace = 1
        // Output: false
        int[] flowerbed2 = {1, 0, 0, 1};
        boolean result2 = canPlaceFlower.canPlaceFlowers(flowerbed2, 1);
        System.out.println(result2);  // false

        // Input: flowerbed = [1, 0, 0, 0, 1], numFlowersToPlace = 1
        // Output: true
        int[] flowerbed3 = {1, 0, 0, 0, 1};
        boolean result3 = canPlaceFlower.canPlaceFlowers(flowerbed3, 1);
        System.out.println(result3);  // true

        // Input: flowerbed = [0, 0, 1], numFlowersToPlace = 1
        // Output: false
        int[] flowerbed4 = {0, 0, 1};
        boolean result4 = canPlaceFlower.canPlaceFlowers(flowerbed4, 1);
        System.out.println(result4);  // true

        // Input: flowerbed = [1, 0, 0], numFlowersToPlace = 1
        // Output: false
        int[] flowerbed5 = {1, 0, 0};
        boolean result5 = canPlaceFlower.canPlaceFlowers(flowerbed5, 1);
        System.out.println(result5);  // true

        // Input: flowerbed = [1, 0, 0, 0, 1], numFlowersToPlace = 2
        // Output: false
        int[] flowerbed6 = {1, 0, 0, 0, 1};
        boolean canPlaceFlower2 = canPlaceFlower.canPlaceFlowers(flowerbed6, 2);
        System.out.println(canPlaceFlower2);  // false

        // Input: flowerbed = [0, 0, 0], numFlowersToPlace = 2
        // Output: true
        int[] flowerbed7 = {0, 0, 0};
        boolean canPlaceFlower3 = canPlaceFlower.canPlaceFlowers(flowerbed7, 2);
        System.out.println(canPlaceFlower3);  // true

        // Input: flowerbed = [0, 1, 0, 1, 0, 1, 0, 0], numFlowersToPlace = 1
        // Output: true
        int[] flowerbed8 = {0, 1, 0, 1, 0, 1, 0, 0};
        boolean canPlaceFlower4 = canPlaceFlower.canPlaceFlowers(flowerbed8, 1);
        System.out.println(canPlaceFlower4);  // true
    }

    /**
     * You have a long flowerbed in which some of the plots are planted, and some are not.
     * However, flowers cannot be planted in adjacent plots.
     *
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1
     * means not empty, and an integer n, return if n new flowers can be planted in the
     * flowerbed without violating the no-adjacent-flowers rule.
     *
     *
     * Preconditions:
     * - flowerbed.length >= 1
     * - flowerbed[i] = 0 or flowerbed[i] = 1.
     * - There are no two adjacent flowers in flowerbed initially.
     * - 0 <= numFlowersToPlace <= flowerbed.length
     */
    public boolean canPlaceFlowers(int[] flowerbed, int numFlowersToPlace) {
        int[] newFlowerbed = new int[flowerbed.length + 2];
        for (int i = 1; i < flowerbed.length + 1; i++) {
            newFlowerbed[i] = flowerbed[i - 1];
        }

        for (int i = 1; i < newFlowerbed.length - 1; i++) {
            if (newFlowerbed[i] == 1) {
                continue;  // spot taken
            }

            if (newFlowerbed[i - 1] == 0 && newFlowerbed[i + 1] == 0) {
                newFlowerbed[i] = 1;
                numFlowersToPlace--;
            }
        }
        return numFlowersToPlace <= 0;
    }
}
