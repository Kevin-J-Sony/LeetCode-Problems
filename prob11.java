public class prob11 {
    public static void main(String[] args) {
        Solution11 sol = new Solution11();
        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int left_ptr = 0;
        int right_ptr = height.length - 1;
        int wmax = 0;
        int t;
        while (left_ptr < right_ptr) {
            t = (right_ptr - left_ptr) * Math.min(height[left_ptr], height[right_ptr]);
            wmax = Math.max(wmax, t);
            if (height[left_ptr] < height[right_ptr]) {
                left_ptr++;
            } else {
                right_ptr--;
            }
        }
        return wmax;
    }
}