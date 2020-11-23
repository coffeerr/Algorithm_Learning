package LeetCode;

/**
 * @description: 买卖股票的最佳时机
 * @author: Desmand
 * @time: 2020/11/23 8:50 上午
 */

public class LC121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }else if(prices[i]-minPrice > maxProfit){
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}
