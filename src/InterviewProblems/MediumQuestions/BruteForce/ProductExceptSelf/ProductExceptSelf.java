package InterviewProblems.MediumQuestions.BruteForce.ProductExceptSelf;

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
        int[] productsExceptSelf = new int[nums.length];
        for (int indexToExclude = 0; indexToExclude < nums.length; indexToExclude++) {
            int productExceptSelf = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != indexToExclude) {
                    productExceptSelf *= nums[j];
                }
                productsExceptSelf[indexToExclude] = productExceptSelf;
            }
        }
        return productsExceptSelf;
    }
}
