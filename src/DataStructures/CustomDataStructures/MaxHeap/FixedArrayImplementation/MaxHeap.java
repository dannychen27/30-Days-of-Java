package DataStructures.CustomDataStructures.MaxHeap.FixedArrayImplementation;

import java.util.Arrays;

public class MaxHeap {

    // source: https://www.youtube.com/watch?v=t0Cq6tVNRBA min heaps

    private int size;
    private int capacity;
    private int[] items;

    /**
     * Create a new max heap.
     */
    public MaxHeap() {
        size = 0;
        capacity = 10;
        items = new int[capacity];
        Arrays.fill(items, -1);
    }

    /**
     * Return true iff this max heap contains no items.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add the item to this max heap.
     */
    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item; // add last element to end of array
        size++; // expand array
        heapifyUp();
    }

    /**
     * Return the top of this max heap.
     */
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("There are no items in this max heap.");
        }
        return items[0];
    }

    /**
     * Remove and return the top of this max heap.
     */
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("You cannot delete from an empty max heap.");
        }

        int item = items[0];
        items[0] = items[size - 1]; // move last element to root
        items[size - 1] = -1; // remove item from last element of array
        size--; // shrink array
        heapifyDown();
        return item;
    }

    /**
     * Return a string representation of this max heap.
     */
    public String toString() {
        String maxHeapString = "";
        for (int i = 0; i < size; i++) {
            maxHeapString += items[i] + " ";
        }

        maxHeapString = maxHeapString.trim();
        if (size >= 1) {
            maxHeapString += " ";
        }

        maxHeapString += "Size: " + size;
        return maxHeapString;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }

    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            // copy over items into a bigger array
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private int getBiggerChildIndex(int index) {
        int biggerChildIndex = getLeftChildIndex(index);
        if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
            biggerChildIndex = getRightChildIndex(index);
        }
        return biggerChildIndex;
    }

    private void heapifyDown() {
        int index = 0; // start with root
        while (hasLeftChild(index)) {  // no left child => no right child
            int biggerChildIndex = getBiggerChildIndex(index);
            if (items[index] > items[biggerChildIndex]) {
                break; // heap elements now in order
            } else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1; // start with last element
        while (hasParent(index) && parent(index) < items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
}
