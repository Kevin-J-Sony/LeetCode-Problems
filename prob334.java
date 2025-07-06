public class prob334 {
    public static void main(String[] args) {
        Solution334 sol = new Solution334();
        //int[] ray = {0,4,2,1,0,-1,-3};
        int[] ray = {1,1,-2,6};

        sol.increasingTriplet(ray);
    }
}

class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        // greedy algorithm
        // keep track of index of smallest number **seen so far**
        // we keep track of the index of the second number 
        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int idx = 0; idx < n; idx++) {
            if (nums[idx] > second) {
                return true;
            }

            if (nums[idx] < smallest) {
                smallest = nums[idx];
            } else {
                second = nums[idx];
            }
        }
        return false;
        
    }

}
