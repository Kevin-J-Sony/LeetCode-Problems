import java.util.Arrays;

public class prob1679 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        Solution1679 sol = new Solution1679();

        sol.maxOperations(array, 6);
    }
}

class Solution1679 {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int maxOps = 0;
        int leftptr = 0;
        int rightptr = nums.length - 1;
        int x;
        while (leftptr < rightptr) {
            x = nums[leftptr] + nums[rightptr];
            if (nums[leftptr] + nums[rightptr] == k) {
                maxOps++;
                leftptr++;
                rightptr--;
            } else if (x < k) {
                leftptr++;
            } else {
                rightptr--;
            }
        }

        return maxOps;
    }
}