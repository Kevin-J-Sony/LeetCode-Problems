public class prob1004 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0}; int k = 2;
        // int[] nums = {1,1,0,1}; int k = 1;
        // int[] nums = {0,0,0,1}; int k = 4;
        Solution1004 sol = new Solution1004();
        sol.longestOnes(nums, k);
    }
}

class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        // from the hints given, we know to use a sliding window algorithm to find the largest window
        // containing k zeros or less
        /*
        int n = nums.length;
        int[] cumulativeNums = new int[n];
        cumulativeNums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            cumulativeNums[i] = cumulativeNums[i - 1] + nums[i];
        }

        int max = 0;

        // we know that the sliding window has to contain at least k elements
        for (int windowLength = k; windowLength <= n; windowLength++) {
            // for each length of the window, determine how much zeros is between the two ends
            for (int idx = 0; idx + windowLength - 1 < n && max != windowLength; idx++) {
                // go from (idx) to (idx + windowLength - 1) to have the sliding window have length windowLength
                int numberOfOnes = cumulativeNums[idx + windowLength - 1] - cumulativeNums[idx] + nums[idx];
                int numberOfZeros = windowLength - numberOfOnes;
                if (numberOfZeros <= k) {
                    if (windowLength > max) max = windowLength;
                }
            }
        }
        return max;
        */
        int leftptr = 0;
        int rightptr = 0;

        int n = nums.length;
        int max = 0;
        int numbZerosDetected = 1 - nums[0];
        while (rightptr < n) {
            if (nums[rightptr] == 0) {
                numbZerosDetected++;
            }
            rightptr++;
            if (numbZerosDetected > k) {
                numbZerosDetected--;
                leftptr++;
            }    
            if (max < rightptr - leftptr) max =  rightptr - leftptr;
        }

        return max;
    }
}