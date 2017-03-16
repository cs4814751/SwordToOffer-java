package q32;

/**
 * Created by leibro on 2017/3/16.
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        init(dp);
        dp[0] = array[0];
        for(int i = 1;i < array.length;i ++) {
            if(dp[i - 1] < 0)
                dp[i] = array[i];
            else
                dp[i] = dp[i - 1] + array[i];
        }
        return findMax(dp);


    }

    private int findMax(int[] dp) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < dp.length;i ++) {
            if(dp[i] > max)
                max = dp[i];
        }
        return max;
    }

    private void init(int[] dp) {
        for(int i = 0;i < dp.length;i ++)
            dp[i] = 0;
    }
}
