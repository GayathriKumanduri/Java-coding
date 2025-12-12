package Examples;
/*Given an integer array nums, find the contiguous subarray with the largest product.
Example:
Input: nums =[2,3,-2,4]
Output: 6(subarray[2,3]
)

*/

public class MaximumProductSubarray {
    
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap max and min when multiplied by a negative number
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product of contiguous subarray: " + maxProduct(nums)); // Output: 6
    }

    
}
