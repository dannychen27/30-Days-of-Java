package InterviewProblems.PriorityQueueProblems.RunningMedian;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class RunningMedian {

    public static void main(String[] args) {
        // find the running median of an array of numbers

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(getRunningMedians(array)));
        // [1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5]

        int[] array2 = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        System.out.println(Arrays.toString(getRunningMedians(array2)));
        // [1.0, 1.5, 1.0, 1.5, 1.0, 1.5, 1.0, 1.5, 1.0, 1.5]
    }

    private static double[] getRunningMedians(int[] array) {
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(new SortByDescendingOrder());  // max heap
        PriorityQueue<Integer> upperHalf = new PriorityQueue<>();  // min heap
        double[] medians = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            addNumber(number, lowerHalf, upperHalf);
            rebalanceHeaps(lowerHalf, upperHalf);
            medians[i] = getMedian(lowerHalf, upperHalf);
        }
        return medians;
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowerHalf,
                                  PriorityQueue<Integer> upperHalf) {
        if (lowerHalf.isEmpty() || number < lowerHalf.peek()) {
            lowerHalf.add(number);
        } else {
            upperHalf.add(number);
        }
    }

    private static void rebalanceHeaps(PriorityQueue<Integer> lowerHalf,
                                       PriorityQueue<Integer> upperHalf) {
        PriorityQueue<Integer> biggerHeap;
        if (lowerHalf.size() > upperHalf.size()) {
            biggerHeap = lowerHalf;
        } else {
            biggerHeap = upperHalf;
        }

        PriorityQueue<Integer> smallerHeap;
        if (lowerHalf.size() > upperHalf.size()) {
            smallerHeap = upperHalf;
        } else {
            smallerHeap = lowerHalf;
        }

        // biggerHeap.size() - smallerHeap.size() will never be > 2.
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> lowerHalf,
                                    PriorityQueue<Integer> upperHalf) {
        PriorityQueue<Integer> biggerHeap;
        if (lowerHalf.size() > upperHalf.size()) {
            biggerHeap = lowerHalf;
        } else {
            biggerHeap = upperHalf;
        }

        PriorityQueue<Integer> smallerHeap;
        if (lowerHalf.size() > upperHalf.size()) {
            smallerHeap = upperHalf;
        } else {
            smallerHeap = lowerHalf;
        }

        if (biggerHeap.size() == smallerHeap.size()) {
            return (biggerHeap.peek() + smallerHeap.peek()) / (double) 2;
        } else {
            return biggerHeap.peek();
        }
    }
}

class SortByDescendingOrder implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return b.compareTo(a);
    }
}
