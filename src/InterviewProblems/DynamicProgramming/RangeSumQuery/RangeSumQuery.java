package InterviewProblems.DynamicProgramming.RangeSumQuery;

public class RangeSumQuery {

    int[] array;

    public RangeSumQuery(int[] nums) {
        array = nums;
    }

    public int sumRange(int left, int right) {
        int rangeSum = 0;
        for (int i = left; i <= right; i++) {
            rangeSum += array[i];
        }
        return rangeSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery rangeSum = new RangeSumQuery(nums);
        System.out.println(rangeSum.sumRange(0, 2));  // 1
        System.out.println(rangeSum.sumRange(2, 5));  // -1
        System.out.println(rangeSum.sumRange(0, 5));  // -3
    }
}
