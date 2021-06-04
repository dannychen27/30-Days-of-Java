package DataStructures.CustomDataStructures.MinHeap;

import java.util.Arrays;

public class MinHeap {
    // source: https://www.youtube.com/watch?v=t0Cq6tVNRBA min heaps

    private int size;
    private int capacity;
    private int[] items;

    public MinHeap() {
        size = 0;
        capacity = 10;
        items = new int[capacity];
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
            items = Arrays.copyOf(items, capacity * 2); // copy over items into a bigger array
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }

        int item = items[0];
        items[0] = items[size - 1]; // move last element to root
        items[size - 1] = 0; // remove item from last element of array
        size--; // shrink array
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item; // add last element to end of array
        size++; // expand array
        heapifyUp();
    }

    private int getSmallerChildIndex(int index) {
        int smallerChildIndex = getLeftChildIndex(index);
        if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
            smallerChildIndex = getRightChildIndex(index);
        }
        return smallerChildIndex;
    }

    private void heapifyDown() {
        int index = 0; // start with root
        while (hasLeftChild(index)) {  // no left child => no right child
            int smallerChildIndex = getSmallerChildIndex(index);
            if (items[index] < items[smallerChildIndex]) {
                break; // heap elements now in order
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1; // start with last element
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        System.out.println(Arrays.toString(heap.items)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        heap.add(25);
        System.out.println(Arrays.toString(heap.items)); // [25, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        heap.add(17);
        System.out.println(Arrays.toString(heap.items)); // [17, 25, 0, 0, 0, 0, 0, 0, 0, 0]
        heap.add(20);
        System.out.println(Arrays.toString(heap.items)); // [17, 25, 20, 0, 0, 0, 0, 0, 0, 0]
        heap.add(15);
        System.out.println(Arrays.toString(heap.items)); // [15, 17, 20, 25, 0, 0, 0, 0, 0, 0]
        heap.add(10);
        System.out.println(Arrays.toString(heap.items)); // [10, 15, 20, 25, 17, 0, 0, 0, 0, 0]
        System.out.println();

        System.out.println(heap.poll()); // 10
        System.out.println(Arrays.toString(heap.items)); // [15, 17, 20, 25, 0, 0, 0, 0, 0, 0]
        System.out.println(heap.poll()); // 15
        System.out.println(Arrays.toString(heap.items)); // [17, 25, 20, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(heap.poll()); // 17
        System.out.println(Arrays.toString(heap.items)); // [20, 25, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(heap.poll()); // 20
        System.out.println(Arrays.toString(heap.items)); // [25, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(heap.poll()); // 25
        System.out.println(Arrays.toString(heap.items)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    }
}
