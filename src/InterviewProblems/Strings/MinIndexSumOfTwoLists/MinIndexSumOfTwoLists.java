package InterviewProblems.Strings.MinIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinIndexSumOfTwoLists {

    // Let m = the number of restaurants Andy likes, n = the number of restaurants Doris likes
    // Time: O(m + n) + O(min(m, n)) = O(m + n)
    // --> We must traverse through all of Andy's and Doris's favourite restaurants to obtain their indices,
    // in case we must compute the least list index sums.
    // Space: O(m + n)
    // --> We must store hashmaps for the indices of Andy's and Doris' favourite restaurants.

    public static void main(String[] args) {
        MinIndexSumOfTwoLists minIndexSumOfTwoLists = new MinIndexSumOfTwoLists();

        // Input:
        // andyFavourites = ["a"]
        // dorisFavourites = ["b"]
        // Output: []
        String[] andyFavourites = {"a"};
        String[] dorisFavourites = {"b"};
        String[] commonInterests0 = minIndexSumOfTwoLists.findRestaurant(andyFavourites, dorisFavourites);
        System.out.println(Arrays.toString(commonInterests0));  // []

        // Input:
        // list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"],
        // list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
        // Output: ["Shogun"]
        // Explanation: The only restaurant they both like is "Shogun".
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] commonInterests1 = minIndexSumOfTwoLists.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(commonInterests1));  // ["Shogun"]

        // Input:
        // list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"],
        // list2 = ["KFC", "Shogun", "Burger King"]
        // Output: ["Shogun"]
        // Explanation: The restaurant they both like and have the least index sum is
        // "Shogun" with index sum 1 (0 + 1).
        String[] list3 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list4 = {"KFC", "Shogun", "Burger King"};
        String[] commonInterests2 = minIndexSumOfTwoLists.findRestaurant(list3, list4);
        System.out.println(Arrays.toString(commonInterests2));  // ["Shogun"]

        // Input:
        // list1 = ["a", "b", "c", "d"]
        // list2 = ["d", "c", "b", "a"]
        // Output: ["d", "c", "b", "a"]
        // Explanation: The restaurants they like all have the least index sum of 3.
        String[] list7 = {"a", "b", "c", "d"};
        String[] list8 = {"d", "c", "b", "a"};
        String[] commonInterests4 = minIndexSumOfTwoLists.findRestaurant(list7, list8);
        System.out.println(Arrays.toString(commonInterests4));  // any permutation of ["a", "b", "c", "d"] is OK

        // Input:
        // list1 = ["a", "b", "c", "d"]
        // list2 = ["b", "a", "d", "c"]
        // Output: ["a", "b"]
        // Explanation: The restaurants they like and have the least index sum are "a" and "b" with index sum 1 (0 + 1).
        String[] list9 = {"a", "b", "c", "d"};
        String[] list10 = {"b", "a", "d", "c"};
        String[] commonInterests5 = minIndexSumOfTwoLists.findRestaurant(list9, list10);
        System.out.println(Arrays.toString(commonInterests5));  // any permutation of ["a", "b"] is OK
    }

    /**
     * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a
     * list of favorite restaurants represented by strings.
     *
     * You need to help them find out their common interest with the least list index sum.
     * If there is a choice tie between answers, output all of them with no order requirement.
     *
     * You could assume there always exists an answer.
     *
     * Preconditions:
     * - list1.length() >= 1.
     * - list2.length() >= 1.
     * - list1[i] and list2[i] consist of spaces ' ' and English letters.
     * - All the stings of list1 are unique.
     * - All the stings of list2 are unique.
     */
    public String[] findRestaurant(String[] andyFavourites, String[] dorisFavourites) {
        // We will need the indices of each favourite restaurant, in case we need to compute
        // the "least list index sum" to break ties.
        Map<String, Integer> andyFavouritesToIndices = recordFavouriteRestaurants(andyFavourites);
        Map<String, Integer> dorisFavouritesToIndices = recordFavouriteRestaurants(dorisFavourites);
        Map<String, Integer> commonRestaurantsToListIndexSums =
                findCommonFavouriteRestaurants(andyFavouritesToIndices, dorisFavouritesToIndices);
        int leastListIndexSum = findLowestListIndexSum(commonRestaurantsToListIndexSums);
        return findRestaurantsWithLowestListIndexSum(commonRestaurantsToListIndexSums, leastListIndexSum);
    }

    private Map<String, Integer> recordFavouriteRestaurants(String[] favouriteRestaurants) {
        Map<String, Integer> favouriteRestaurantsToIndices = new HashMap<>();
        for (int i = 0; i < favouriteRestaurants.length; i++) {
            favouriteRestaurantsToIndices.put(favouriteRestaurants[i], i);
        }
        return favouriteRestaurantsToIndices;
    }

    private Map<String, Integer> findCommonFavouriteRestaurants(Map<String, Integer> andyRestaurantsToIndices,
                                                                Map<String, Integer> dorisRestaurantsToIndices) {
        Map<String, Integer> commonRestaurants = new HashMap<>();

        // One slight optimization is to traverse over shorter hashmap instead of longer hashmap, since common
        // interests are limited by the shorter hashmap.
        Map<String, Integer> shorterMap = getShorterHashmap(andyRestaurantsToIndices, dorisRestaurantsToIndices);
        Map<String, Integer> longerMap = getLongerHashmap(andyRestaurantsToIndices, dorisRestaurantsToIndices);
        for (String restaurant : shorterMap.keySet()) {
            // Therefore, we can simply compare the shorter hashmap to the longer hashmap, since we know that
            // hashmap lookup is always O(1) with a good enough hash function.
            if (longerMap.containsKey(restaurant)) {
                int listIndexSum = shorterMap.get(restaurant) + longerMap.get(restaurant);
                commonRestaurants.put(restaurant, listIndexSum);
            }
        }
        return commonRestaurants;
    }

    private Map<String, Integer> getShorterHashmap(Map<String, Integer> hashmap1, Map<String, Integer> hashmap2) {
        if (hashmap1.size() >= hashmap2.size()) {
            return hashmap2;
        } else {  // hashmap1.size() < hashmap2.size()
            return hashmap1;
        }
    }

    private Map<String, Integer> getLongerHashmap(Map<String, Integer> hashmap1, Map<String, Integer> hashmap2) {
        if (hashmap1.size() >= hashmap2.size()) {
            return hashmap1;
        } else {  // hashmap1.size() < hashmap2.size()
            return hashmap2;
        }
    }

    private int findLowestListIndexSum(Map<String, Integer> commonRestaurantsToListIndexSums) {
        int lowestListIndexSum = Integer.MAX_VALUE;
        for (int listIndexSum : commonRestaurantsToListIndexSums.values()) {
            if (listIndexSum < lowestListIndexSum) {
                lowestListIndexSum = listIndexSum;
            }
        }
        return lowestListIndexSum;
    }

    private String[] findRestaurantsWithLowestListIndexSum(Map<String, Integer> commonRestaurantsToListIndexSums,
                                                           int leastListIndexSum) {
        List<String> restaurantsWithLowestListIndexSum = new ArrayList<>();
        for (String restaurant : commonRestaurantsToListIndexSums.keySet()) {
            if (commonRestaurantsToListIndexSums.get(restaurant) == leastListIndexSum) {
                restaurantsWithLowestListIndexSum.add(restaurant);
            }
        }
        return restaurantsWithLowestListIndexSum.toArray(new String[0]);
    }
}
