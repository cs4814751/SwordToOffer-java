package q13;

/**
 * Created by leibro on 2017/3/7.
 */
public class Solution {
    public double Power(double base, int exponent) {
        int n = Math.abs(exponent);
        if(n == 0)
            return 1;
        if(n == 1)
            return base;

        double result = Power(base,n >> 1);
        result *= result;
        if((n & 0x01) == 1)
            result *= base;
        if(exponent < 0)
            result = 1 / result;
        return result;
    }
}
