package q48;

/**
 * Created by leibro on 2017/3/21.
 */
public class Solution {
    public int lastRemaining(int n,int m) {
        int res = helper(n,m);
        return res;
    }

    public int helper(int n,int m) {
        if(n == 1)
            return 0;
        else
            return (helper(n - 1,m) + m + 1) % n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(5,3));
    }

}
