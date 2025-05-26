package Blind75;

import java.util.Arrays;

public class Temp {
    public static void main(String[] args) {
//        int coins[]={2,1,5};
        int coins[] = {1, 5, 6, 9};
        int amount = 31;

        System.out.println(coinChangee(coins, amount));
    }

    private static int coinChangee(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 0; i <= amount; i++) {
            for (int j : coins) {
                if (j> i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - j]+1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    private static void print(int a[]) {
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}

