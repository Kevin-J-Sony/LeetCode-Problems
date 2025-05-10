import java.util.Arrays;

public class prob62 {
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            dp[row][n - 1] = 1;
        }
        for (int col = 0; col < n; col++) {
            dp[m-1][col] = 1;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }
        }

        //. dp[i][j] = dp[i + 1][j] + dp[i][j + 1];

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));

        }
        return 1;
    }

    public static void main(String[] args) {
        uniquePaths(3, 7);
    }
}
