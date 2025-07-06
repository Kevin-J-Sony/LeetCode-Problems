public class prob605 {
    public static void main(String[] args) {
        int[] array = {1,0,0,0,0,0,1};
        Solution605 sol = new Solution605();

        System.out.println(sol.canPlaceFlowers(array, 2));
    }
}


class Solution605 {
    public int canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n > len / 2 + 1) {
            return 0;
        }

        int count = 0;
        int ptr = -1;
        // first consider case where start off at 0
        if (flowerbed[0] == 0) {
            if (1 < len && flowerbed[1] == 0) {
                count++;
                ptr += 2;
            } else {
                ptr++;
            }
        }

        while (ptr < len) {
            // we want to check three conditions
            // first that the next element after rightptr is 0
            // we know this is true because of condition
            // then if the second next element is 1 or not
            // and if the third next element is 1 or not.
            // only in the case where all three is zero can we increase the count by one
            if (ptr + 2 < len && flowerbed[ptr + 2] == 0) {
                if (ptr + 3 < len && flowerbed[ptr + 3] == 0) {
                    count++;
                }
            }
            ptr += 2;
        }
        return count;
    }
}