package InterviewProblems.Sorting.MajorityElement;

public class MajorityElementTwoVariables {

    public static void main(String[] args) {
        MajorityElementTwoVariables majorityElement = new MajorityElementTwoVariables();

        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement.majorityElement(nums1));  // 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement.majorityElement(nums2));  // 2
    }

    public int majorityElement(int[] nums) {
        int majorityElement = -1;  // this can be any number, really.
        int count = 0;
        for (int number : nums) {
            if (count == 0) {
                majorityElement = number;
            }

            if (number == majorityElement) {
                count++;
            } else {
                count--;
            }
        }
        return majorityElement;
    }
}
