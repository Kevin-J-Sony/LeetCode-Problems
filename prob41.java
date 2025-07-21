import java.util.Arrays;

public class prob41 {
    public static void main(String[] args) {
        Solution41 sol = new Solution41();
        int[] ray = {4,3,5,2,1};
        System.out.println(sol.firstMissingPositive(ray));
    }
}


class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // use cycle sort to put values in "right" position
        int t;
        for (int idx = 0; idx < n; idx++) {
            while (nums[idx] >= 1 && nums[idx] <= n && nums[idx] != nums[nums[idx] - 1]) {
                t = nums[nums[idx] - 1];
                nums[nums[idx] - 1] = nums[idx];
                nums[idx] = t;
            }
        }
        
        for (int idx = 0; idx < n; idx++) {
            if (nums[idx] != idx + 1) {
                return idx + 1;
            }
        }

        return n + 1;
    }
}