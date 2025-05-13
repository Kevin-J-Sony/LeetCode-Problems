public class prob334 {
    public static void main(String[] args) {
        Solution334 sol = new Solution334();
        //int[] ray = {0,4,2,1,0,-1,-3};
        int[] ray = {1,5,0,4,1,3};
        sol.increasingTriplet(ray);
    }
}

class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        // count the number of elements at a certain index
        // that is greater than it succeeding the index
        /*
        int[] numb_greater_than = new int[nums.length];
        numb_greater_than[nums.length - 1] = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            numb_greater_than[i] = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    numb_greater_than[i] = Math.max(numb_greater_than[i], numb_greater_than[j] + 1);
                }
            }
            if (numb_greater_than[i] >= 3) {
                return true;
            }
        }
        return false;
        */
        boolean[] prev = new boolean[nums.length];
        boolean[] succ = new boolean[nums.length];

        prev[0] = false;
        for (int i = 1; i < prev.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    prev[i] = true;
                    j = 0;
                }
            }
        }

        succ[succ.length - 1] = false;
        for (int i = succ.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < succ.length; j++) {
                if (nums[j] > nums[i]) {
                    succ[i] = true;
                    j = succ.length;
                }
            }
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (succ[i + 1] && prev[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
