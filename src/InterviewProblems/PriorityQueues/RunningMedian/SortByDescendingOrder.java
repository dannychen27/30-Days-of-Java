package InterviewProblems.PriorityQueues.RunningMedian;

import java.util.Comparator;

class SortByDescendingOrder implements Comparator<Integer> {

    public int compare(Integer a, Integer b) {
        return b.compareTo(a);
    }
}
