public class prob238 {
    public static void main(String[] args) {
        Solution238 sol = new Solution238();
        int[] arr = {1, 2, 3, 4};
        sol.productExceptSelf(arr);
    }
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] prev = new int[nums.length];
        int[] succ = new int[nums.length];

        // prev is product up to current index
        prev[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prev[i] = nums[i] * prev[i - 1];
        }

        // succ is product succeeding current index
        succ[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            succ[i] = nums[i] * succ[i + 1];
        }

        int[] tot_prod = new int[nums.length];
        tot_prod[0] = 1 * succ[1];
        tot_prod[nums.length - 1] = prev[nums.length - 2] * 1;
        for (int i = 1; i < nums.length - 1; i++) {
            tot_prod[i] = succ[i + 1] * prev[i - 1];
        }
        return tot_prod;
    }
}