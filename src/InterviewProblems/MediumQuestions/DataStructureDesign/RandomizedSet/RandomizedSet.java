package InterviewProblems.MediumQuestions.DataStructureDesign.RandomizedSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    private final Map<Integer, Integer> valuesToIndices;
    private final List<Integer> values;
    private final Random random;

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));  // true
        System.out.println(randomizedSet.remove(2));  // false
        System.out.println(randomizedSet.insert(2));  // true
        System.out.println(randomizedSet.getRandom());  // 1 or 2
        System.out.println(randomizedSet.remove(1));  // true
        System.out.println(randomizedSet.insert(2));  // false
        System.out.println(randomizedSet.getRandom());  // 2
    }

    public RandomizedSet() {
        // - O(1) insert() -- store the array index to look up a value's index in the array in O(1) time
        // - O(1) remove() -- use array index to remove any item from the array in O(1) time
        valuesToIndices = new HashMap<>();

        // - O(1) getRandom() for indexing anywhere in the array
        values = new ArrayList<>();
        random = new Random();
    }

    /**
     * Insert an item val into the set, if it doesn't already exist.
     * Return true if the item was not present, false otherwise.
     */
    public boolean insert(int newValue) {
        if (valuesToIndices.containsKey(newValue)) {
            return false;  // item already exists
        }

        // add new item
        valuesToIndices.put(newValue, values.size());
        values.add(newValue);
        return true;
    }

    /**
     * Remove the item val from the set if present.
     * Return true if the item was present, false otherwise.
     */
    public boolean remove(int oldValue) {
        if (!valuesToIndices.containsKey(oldValue)) {
            return false;  // nothing to remove
        }

        int indexToRemove = valuesToIndices.get(oldValue);
        int lastItem = values.get(values.size() - 1);

        // swap the desired index with the index of the end of array so that when we
        // try to remove the desired element from the array, we don't create a gap
        // in the array that we'd need to fill by shift the remaining elements.
        values.set(indexToRemove, lastItem);  // like items[indexToRemove] = lastItem;
        valuesToIndices.put(lastItem, indexToRemove);  // like valuesToIndices[lastItem] = indexToRemove;

        // remove old item
        valuesToIndices.remove(oldValue);
        values.remove(values.size() - 1);
        return true;
    }

    /**
     * Returns a random element from the randomized set.
     * Each element must have the same probability of being returned.
     *
     * Preconditions:
     * - at least one element exists in this randomized set.
     */
    public int getRandom() {
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}
