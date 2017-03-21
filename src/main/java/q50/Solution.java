package q50;

/**
 * Created by leibro on 2017/3/21.
 */
public class Solution {
    public int Add(int num1,int num2) {
        int xor = num1 ^ num2;
        int and = (num1 & num2) << 1;
        if(and == 0)
            return xor;
        return Add(xor,and);
    }

    public static void main(String[] args) {
        Integer.parseInt("-214748365");
    }
}
