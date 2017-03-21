package q49;

/**
 * Created by leibro on 2017/3/21.
 */
public class Solution {
    public int Sum_Solution(int n) {
        int result = 0;
        int a = 1;
        boolean t = (n != 0) && a == (result = Sum_Solution(n - 1));
        return result += n;
    }
}
