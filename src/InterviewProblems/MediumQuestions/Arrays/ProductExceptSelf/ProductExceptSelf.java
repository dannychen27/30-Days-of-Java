package InterviewProblems.MediumQuestions.Arrays.ProductExceptSelf;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();

        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf.productExceptSelf(nums1);
        System.out.println(Arrays.toString(result1));  // [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf.productExceptSelf(nums2);
        System.out.println(Arrays.toString(result2));  // [0, 0, 9, 0, 0]
    }

    public int[] productExceptSelf(int[] nums) {
        // prefixProducts contains the product of all the elements in nums[0:i]
        int[] prefixProducts = new int[nums.length];
        prefixProducts[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        // postfixProducts contains the product of all the elements in nums[i:nums.length]
        int[] postfixProducts = new int[nums.length];
        postfixProducts[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            postfixProducts[i] = postfixProducts[i + 1] * nums[i + 1];
        }

        int[] productExceptSelf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            productExceptSelf[i] = prefixProducts[i] * postfixProducts[i];
        }
        return productExceptSelf;
    }
}
