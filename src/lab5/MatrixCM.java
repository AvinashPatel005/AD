package lab5;

import java.util.Arrays;

public class MatrixCM {
    static int MatrixChainMul(int[] p, int n) {
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 1; i < n; i++)
            dp[i][i] = 0;

        for (int l = 1; l < n; l++) { // l is length of range.
            for (int i = 1, j = i + l; j < n; i++, j++) {
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + p[i - 1] * p[k] * p[j] + dp[k + 1][j]);
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int n = arr.length;
        System.out.println("Matrix Chain Multiplication is: " + MatrixChainMul(arr, n));

    }
}
