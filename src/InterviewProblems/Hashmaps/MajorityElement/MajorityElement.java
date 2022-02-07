package InterviewProblems.Hashmaps.MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();

        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement.majorityElement(nums1));  // 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement.majorityElement(nums2));  // 2
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> elementsToCounts = new HashMap<>();
        for (int number : nums) {
            if (elementsToCounts.containsKey(number)) {
                elementsToCounts.put(number, elementsToCounts.get(number) + 1);
            } else {
                elementsToCounts.put(number, 1);
            }
        }

        return findMajorityElement(elementsToCounts, nums.length / 2);
    }

    private int findMajorityElement(Map<Integer, Integer> elementsToCounts, int threshold) {
        for (Map.Entry<Integer, Integer> entry : elementsToCounts.entrySet()) {
            if (entry.getValue() > threshold) {
                return entry.getKey();
            }
        }
        return -1;  // this is impossible, there must be a majority element
    }
}
