public class BestTimeToBuySellStockTransFee {

    public static int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int effectiveBuy = prices[0];
        for (int price : prices) {
            profit = Math.max(profit, price - effectiveBuy - fee);
            effectiveBuy = Math.min(effectiveBuy, price-profit);
        }
        return profit;
    }
    
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9}, 2));
        System.out.println(maxProfit(new int[]{1,3,7,5,10,3}, 3));
    }
}
