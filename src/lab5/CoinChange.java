package lab5;

import java.util.Arrays;

public class CoinChange {
    static int minCoins(int[] coins, int n, int val) {
        int[] count = new int[val + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;

        for (int i = 1; i <= val; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i && count[i - coins[j]] != Integer.MAX_VALUE && count[i] > count[i - coins[j]] + 1) {
                    count[i] = count[i - coins[j]] + 1;
                }
            }
        }
        return (count[val] != Integer.MAX_VALUE) ? count[val] : -1;
    }
    public static void main(String[] args) {
        int[] coins = { 5, 6 };
        int value = 16;
        int n = coins.length;
        System.out.println("Count is : " + minCoins(coins, n, value));
    }
}
