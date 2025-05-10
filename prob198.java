class prob198 {
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        int[] total_stolen = new int[len];
        total_stolen[0] = nums[0];
        total_stolen[1] = nums[1];
        
        int global_max = Math.max(total_stolen[0], total_stolen[1]);
        // stolen focus
        for (int i = 1; i < len; i++) {
            int local_max = 0;
            for (int j = i - 2; j >= 0; j--) {
                if (total_stolen[j] > local_max)
                    local_max = total_stolen[j];
            }
            total_stolen[i] = local_max + nums[i];
            if (total_stolen[i] > global_max)
                global_max = total_stolen[i];
        }

        for (int element : total_stolen) {
            System.out.printf("%d ", element);
        }
        System.out.println("\n\n");

        return global_max;
    }

    public static void main(String[] args) {
        int[] moneys = {1,2,3,1};
        System.out.printf("Amount stolen: %d\n", rob(moneys));
    }
}