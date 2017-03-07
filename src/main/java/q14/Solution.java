package q14;

/**
 * Created by leibro on 2017/3/7.
 */
public class Solution {
/*    public void Print1ToMaxOfNDigits(int n) {
        if(n <= 0)
            return;
        StringBuilder sb = new StringBuilder(n);
        init(sb);
        while(increment(sb)) {
            print(sb);
        }
    }

    private boolean increment(StringBuilder sb) {
        int over = 0;
        boolean inc = false;
        for(int i = sb.length() - 1;i >= 0;i --) {
            if(over == 1) {
                over = afterInc(sb,i);
                if(over == -1)
                    return false;
            }
            if(!inc)
                over = afterInc(sb,i);
            if(over == -1)
                return false;
            if(over == 0)
                return true;
            if(i == sb.length() - 1)
                inc = true;
        }
        return true;
    }

    private void print(StringBuilder sb) {
        int i = -1;
        for(int j = 0;j < sb.length();j ++) {
            char c = sb.charAt(j);
            if(c != '0') {
                i = j;
                break;
            }
        }
        for(int j = i;j < sb.length();j ++) {
            char c = sb.charAt(j);
            System.out.print(c);
            if(j == sb.length() - 1)
                System.out.print("\n");
        }
    }

    private void init(StringBuilder sb) {
        for(int i = 0;i < sb.capacity();i ++)
            sb.insert(i,'0');
    }

    private int afterInc(StringBuilder sb,int i) {
        char c = sb.charAt(i);
        if(c == '9') {
            if(i == 0)
                return -1;
            sb.setCharAt(i, '0');
            return 1;
        } else {
            sb.setCharAt(i,(char)(c + 1));
            return 0;
        }
    }*/

    public void Print1ToMaxOfNDigits(int n) {
        if(n <= 0)
            return;
        StringBuilder sb = new StringBuilder(n);
        init(sb);
        Print1ToMaxOfNDigits(sb,0);
    }

    public void Print1ToMaxOfNDigits(StringBuilder sb,int i) {
        if(i == sb.length() - 1) {
            for(int j = 0;j <= 9;j ++) {
                sb.setCharAt(i,(char)('0' + j));
                print(sb);
            }
            return;
        }
        for(int j = 0;j <= 9;j ++) {
            sb.setCharAt(i,(char)('0' + j));
            Print1ToMaxOfNDigits(sb, i + 1);
        }
    }

    private void init(StringBuilder sb) {
        for(int i = 0;i < sb.capacity();i ++)
            sb.insert(i,'0');
    }

    private void print(StringBuilder sb) {
        int i = 0;
        for(int j = 0;j < sb.length();j ++) {
            char c = sb.charAt(j);
            if(c != '0') {
                i = j;
                break;
            }
        }
        for(int j = i;j < sb.length();j ++) {
            char c = sb.charAt(j);
            System.out.print(c);
            if(j == sb.length() - 1)
                System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        new Solution().Print1ToMaxOfNDigits(6);
    }
}
