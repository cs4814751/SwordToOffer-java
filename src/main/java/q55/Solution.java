package q55;

/**
 * Created by leibro on 2017/3/21.
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0)
            return false;
        int i = 0;
        if(sign(str[0]))
            i ++;
        if(i == str.length)
            return false;
        int j = scanDigits(str,i);
        if(j == str.length)
            return true;
        i = j;
        if(str[i] == '.' ) {
            i ++;
            int n = scanDigits(str,i);
            if(n == str.length)
                return true;
            i = n;
            if(str[i] == 'E' || str[i] == 'e') {
                return isExp(str,i);
            } else {
                return false;
            }
        } else if(str[i] == 'e' || str[i] == 'E') {
            return isExp(str,i);
        } else {
            return false;
        }
    }

    private boolean sign(char c) {
        if(c == '+' || c == '-')
            return true;
        else
            return false;
    }

    private boolean isExp(char[] str,int i) {
        if(++ i < str.length) {
            if(sign(str[i]))
                i ++;
        } else {
            return false;
        }
        if(i < str.length)
            i = scanDigits(str,i);
        if(i == str.length)
            return true;
        else
            return false;
    }

    private int scanDigits(char[] str,int i) {
        while(str[i] >= '0' && str[i] <= '9') {
            i ++;
            if(i == str.length)
                break;
        }
        return i;
    }

}
