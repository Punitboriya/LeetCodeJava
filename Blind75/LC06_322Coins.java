package Blind75;

import java.util.Arrays;

public class LC06_322Coins {

    public static void main(String[] args) {
//        int coins[]={1,5,6,9};
        int coins[] = {2, 1, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
//        System.out.println(coinsTotal(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        // Create a DP array where dp[i] represents the minimum coins for amount i
        int[] dp = new int[amount + 1];

        // Initialize with a value larger than the maximum possible coins needed
        Arrays.fill(dp, amount + 1);
        print(dp);

        // Base case: 0 coins needed for amount 0
        dp[0] = 0;

        // Sort coins to potentially exit early in some cases
        Arrays.sort(coins);

        print(dp);
        print(coins);

        // Build up the solution from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // Try each coin denomination
            for (int j : coins) {
                // If current coin is larger than amount, break (since coins are sorted)
                if (j > i) {
                    break;
                }
                // Update dp[i] with the minimum coins needed
                dp[i] = Math.min(dp[i], dp[i - j] + 1);
            }
        }
        // Return the result or -1 if not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }

    private static int coinsTotal(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int dp[] = new int[amount + 1];
        //-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        Arrays.fill(dp, -1);
        print(dp);

        //put 1 at exect coin in dp
        //-1,1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }
        print(dp);


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {

                    if (dp[i] == -1) {
                        dp[i] = dp[i - coins[j]] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
        }
        print(dp);


        return dp[amount];
    }

    private static void print(int a[]) {
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

}
