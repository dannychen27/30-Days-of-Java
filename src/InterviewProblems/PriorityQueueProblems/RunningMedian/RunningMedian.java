package InterviewProblems.PriorityQueueProblems.RunningMedian;

import java.util.PriorityQueue;

public class RunningMedian {

    // source: https://www.youtube.com/watch?v=VmogG01IjYc&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=12&t=6s

    // Find the running median of an array of numbers

    public double[] getRunningMedians(int[] array) {
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

    private void addNumber(int number,
                           PriorityQueue<Integer> lowerHalf,
                           PriorityQueue<Integer> upperHalf) {
        if (lowerHalf.isEmpty() || number < lowerHalf.peek()) {
            lowerHalf.add(number);
        } else {
            upperHalf.add(number);
        }
    }

    private void rebalanceHeaps(PriorityQueue<Integer> lowerHalf,
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

    private double getMedian(PriorityQueue<Integer> lowerHalf,
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
            return (biggerHeap.peek() + smallerHeap.peek()) / 2.0;
        } else {
            return biggerHeap.peek();
        }
    }
}
