package Algorithms.SortingAlgorithms.HeapSort;

import DataStructures.CustomDataStructures.MaxHeap.FixedArrayImplementation.MaxHeap;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        int[] array = {5, 2, 4, 6, 1, 3};
        heapSort.heapSort(array);
        System.out.println(Arrays.toString(array));  // [1, 2, 3, 4, 5, 6]

        int[] array2 = {5, 2, 4, 6, 1, 3};
        heapSort.smarterHeapSort(array2);
        System.out.println(Arrays.toString(array2));  // [1, 2, 3, 4, 5, 6]
    }

    public void heapSort(int[] array) {
        MaxHeap maxHeap = buildHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = maxHeap.poll();
        }
    }

    public void smarterHeapSort(int[] array) {
        smarterBuildHeap(array);  // TODO: Make buildHeap() method inside the MinHeap and MaxHeap classes instead.
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapifyDown(array, 0, i);
        }
    }

    // Time: O(n log(n))
    // Space: O(n)
    public MaxHeap buildHeap(int[] array) {
        MaxHeap maxHeap = new MaxHeap();
        for (int number : array) {
            maxHeap.add(number);
        }
        return maxHeap;
    }

    // Time: O(n)
    // Space: O(n)
    public void smarterBuildHeap(int[] array) {
        int lastInternalNodeIndex = getLastInternalNodeIndex(array);
        for (int i = lastInternalNodeIndex; i >= 0; i--) {
            heapifyDown(array, i, array.length);
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private boolean hasLeftChild(int index, int stoppingIndex) {
        return getLeftChildIndex(index) < stoppingIndex;
    }
    private boolean hasRightChild(int index, int indexToStop) {
        return getRightChildIndex(index) < indexToStop;
    }

    private int leftChild(int[] array, int index) { return array[getLeftChildIndex(index)]; }
    private int rightChild(int[] array, int index) { return array[getRightChildIndex(index)]; }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private int getLastInternalNodeIndex(int[] array) {
        if (array.length % 2 == 0) {
            return array.length / 2 - 1;
        } else {  // array.length % 2 != 0
            return array.length / 2;
        }
    }

    private int getBiggerChildIndex(int[] array, int index, int indexToStop) {
        int biggerChildIndex = getLeftChildIndex(index);
        if (hasRightChild(index, indexToStop) && rightChild(array, index) > leftChild(array, index)) {
            biggerChildIndex = getRightChildIndex(index);
        }
        return biggerChildIndex;
    }

    private void heapifyDown(int[] array, int startingIndex, int stoppingIndex) {
        int index = startingIndex;
        while (hasLeftChild(stoppingIndex, index)) {  // no left child => no right child
            int biggerChildIndex = getBiggerChildIndex(array, index, stoppingIndex);
            if (array[index] > array[biggerChildIndex]) {
                break;
            } else {
                swap(array, index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }
}
