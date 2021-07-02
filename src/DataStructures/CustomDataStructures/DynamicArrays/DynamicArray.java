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
     * Add this item to the end of the dynamic array.
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
        for (int item : array) {
            dynamicArrayString += item + " ";
        }
        dynamicArrayString = dynamicArrayString.trim();
        dynamicArrayString += "\n";
        dynamicArrayString += "Size: " + size + "\n";
        return dynamicArrayString;
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        System.out.println(dynamicArray);  // empty string

        dynamicArray.append(1);
        System.out.println(dynamicArray);  // 1
        dynamicArray.append(2);
        System.out.println(dynamicArray);  // 1 2
        dynamicArray.append(3);
        System.out.println(dynamicArray);  // 1 2 3
        dynamicArray.append(4);
        System.out.println(dynamicArray);  // 1 2 3 4

        System.out.println("Popped: " + dynamicArray.delete());  // 4
        System.out.println(dynamicArray);  // 1 2 3
        System.out.println("Popped: " + dynamicArray.delete());  // 3
        System.out.println(dynamicArray);  // 1 2
        System.out.println("Popped: " + dynamicArray.delete());  // 2
        System.out.println(dynamicArray);  // 1
        System.out.println("Popped: " + dynamicArray.delete());  // 1
        System.out.println(dynamicArray);  // empty string
        System.out.println(dynamicArray.isEmpty());  // true
        // System.out.println("Popped: " + dynamicArray.delete());  // this throws an IllegalStateException
    }

    private void ensureSmallEnoughCapacity() {
        if (capacity < 4) {
            return;  // The dynamic array is too small to shrink any further.
        }

        if (size > Math.ceil(capacity / 4)) {
            return;  // The dynamic array isn't small enough to shrink. we want to shrink when load factor = 1/4.
        }

        array = Arrays.copyOf(array, capacity / 4);
        capacity /= 4;
    }

    private void ensureLargeEnoughCapacity() {
        if (size < capacity) {
            return;  // the dynamic array isn't big enough to expand. we want to grow when load factor = 1.
        }

        array = Arrays.copyOf(array, capacity * 2);
        Arrays.fill(array, capacity + 1, 2 * capacity, -1);
        capacity *= 2;
    }
}
