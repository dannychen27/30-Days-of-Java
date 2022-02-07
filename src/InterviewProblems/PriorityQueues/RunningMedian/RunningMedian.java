package InterviewProblems.PriorityQueues.RunningMedian;

import java.util.PriorityQueue;

public class RunningMedian {

    // source: https://www.youtube.com/watch?v=VmogG01IjYc&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=12&t=6s

    // Find the running median of an array of numbers

    public double[] getRunningMedians(int[] numbers) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new SortByDescendingOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        double[] medians = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            addNumber(numbers[i], maxHeap, minHeap);
            rebalanceHeaps(maxHeap, minHeap);
            medians[i] = getMedian(maxHeap, minHeap);
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
        PriorityQueue<Integer> biggerHeap = getBiggerHeap(lowerHalf, upperHalf);
        PriorityQueue<Integer> smallerHeap = getSmallerHeap(lowerHalf, upperHalf);

        // biggerHeap.size() - smallerHeap.size() will never be > 2.
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private double getMedian(PriorityQueue<Integer> lowerHalf,
                             PriorityQueue<Integer> upperHalf) {
        PriorityQueue<Integer> biggerHeap = getBiggerHeap(lowerHalf, upperHalf);
        PriorityQueue<Integer> smallerHeap = getSmallerHeap(lowerHalf, upperHalf);

        if (biggerHeap.size() == smallerHeap.size()) {
            return (biggerHeap.peek() + smallerHeap.peek()) / 2.0;
        } else {
            return biggerHeap.peek();
        }
    }

    private PriorityQueue<Integer> getSmallerHeap(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf) {
        PriorityQueue<Integer> smallerHeap;
        if (lowerHalf.size() > upperHalf.size()) {
            smallerHeap = upperHalf;
        } else {
            smallerHeap = lowerHalf;
        }
        return smallerHeap;
    }

    private PriorityQueue<Integer> getBiggerHeap(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf) {
        PriorityQueue<Integer> biggerHeap;
        if (lowerHalf.size() > upperHalf.size()) {
            biggerHeap = lowerHalf;
        } else {
            biggerHeap = upperHalf;
        }
        return biggerHeap;
    }
}
