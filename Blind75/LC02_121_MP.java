package Blind75;

public class LC02_121_MP {

    public static void main(String[] args) {

//		int prices[] = { 7, 1, 5, 3, 6, 4 };

        int prices[] = { 7, 6, 4, 3, 1 };

        System.out.println("Maximum Profit is :" + maxProfit(prices));
    }

    private static int maxProfit(int[] p) {

        int min = p[0];
        int profit = 0;

        for (int i = 0; i < p.length; i++) {

            if (p[i] < min) {
                min = p[i];
                System.out.println("Sell " + min);
            }

            profit = Math.max(profit, p[i] - min);
            System.out.println("Profit " + profit);
            System.out.println("----------");
        }

        return profit;
    }

}
