package InterviewProblems.MediumQuestions.Arrays.ProductExceptSelf;

import java.util.Arrays;

public class ProductExceptSelfSpaceEfficient {

    public static void main(String[] args) {
        ProductExceptSelfSpaceEfficient productExceptSelfSpaceEfficient = new ProductExceptSelfSpaceEfficient();

        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelfSpaceEfficient.productExceptSelf(nums1);
        System.out.println(Arrays.toString(result1));  // [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelfSpaceEfficient.productExceptSelf(nums2);
        System.out.println(Arrays.toString(result2));  // [0, 0, 9, 0, 0]
    }

    public int[] productExceptSelf(int[] nums) {
        int[] productsExceptSelf = new int[nums.length];

        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            productsExceptSelf[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int postfixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productsExceptSelf[i] *= postfixProduct;
            postfixProduct *= nums[i];
        }

        return productsExceptSelf;
    }
}
