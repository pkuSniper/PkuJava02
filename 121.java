public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int max=0, min=prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i] < min)
                min = prices[i];
            if(prices[i]-min > max)
                max = prices[i]-min;
        }
        return max;
    }
}