package DataStructures.CustomDataStructures.DynamicArrays;

import java.util.Arrays;

public class DynamicArray {

    private int size;
    private int capacity;
    private int[] array;

    /**
     * Create a new dynamic array.
     */
    public DynamicArray() {
        size = 0;
        capacity = 1;
        array = new int[capacity];
        Arrays.fill(array, -1);
    }

    /**
     * Return true iff this dynamic array has no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the capacity of this dynamic array.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Add this item to the end of this dynamic array.
     */
    public void append(int newItem) {
        ensureLargeEnoughCapacity();
        array[size] = newItem;
        size++;
    }

    /**
     * Delete the item at the end of the dynamic array.
     */
    public int delete() {
        ensureSmallEnoughCapacity();
        if (isEmpty()) {
            throw new IllegalStateException("You cannot delete from an empty dynamic array.");
        }

        size--;
        int oldItem = array[size];
        array[size] = -1;
        return oldItem;
    }

    /**
     * Return a string representation of this dynamic array.
     */
    public String toString() {
        String dynamicArrayString = "";
        for (int i = 0; i < size; i++) {
            dynamicArrayString += array[i] + " ";
        }

        dynamicArrayString = dynamicArrayString.trim();
        if (size >= 1) {
            dynamicArrayString += " ";
        }

        dynamicArrayString += "Size: " + size + "\n";
        return dynamicArrayString;
    }

    private void ensureSmallEnoughCapacity() {
        if (capacity < 4) {
            // The dynamic array is too small to shrink any further.
            // If we allow the array to shrink to size 0, we can no longer double the array's size.
            return;
        }

        if (size > Math.ceil(capacity / 4)) {
            // The dynamic array isn't small enough to shrink.
            // We want to shrink when load factor = 1 / 4.
            return;
        }

        contract();
    }

    private void ensureLargeEnoughCapacity() {
        if (size < capacity) {
            // The dynamic array isn't big enough to expand.
            // We want to grow when load factor = 1.
            return;
        }

        expand();
    }

    private void contract() {
        array = Arrays.copyOf(array, capacity / 4);
        capacity /= 4;
    }

    private void expand() {
        array = Arrays.copyOf(array, capacity * 2);
        Arrays.fill(array, capacity + 1, 2 * capacity, -1);
        capacity *= 2;
    }
}
