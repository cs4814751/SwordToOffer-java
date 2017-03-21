package q51;

/**
 * Created by leibro on 2017/3/21.
 */
public class STOI {
    public int strToIntPos(String s) {
        int multmin = Integer.MAX_VALUE / 10;
        int result = 0;
        for(int i = 0;i < s.length();i ++) {
            int digit = Character.digit(s.charAt(i),10);
            if(result > multmin)
                throw new UnsupportedOperationException();
            result *= 10;
            if(Integer.MAX_VALUE - result < digit)
                throw new UnsupportedOperationException();
            result += digit;
        }
        return result;
    }

    public int strToInt(String s) {
        int result = 0;
        boolean negative = false;
        int minValue = - Integer.MAX_VALUE;
        int i = 0;
        if(s.charAt(0) < '0') {
            if(s.charAt(0) == '+') {
                negative = false;
            }
            else if(s.charAt(0) == '-') {
                negative = true;
                minValue = -Integer.MIN_VALUE;
            }
            else
                throw new UnsupportedOperationException("符号位错误");
            i ++;
        }
        int multmin = minValue / 10;
        for(int k = i;k < s.length();k ++) {
            int digit = Character.digit(s.charAt(k),10);
            if(digit < 0)
                throw new UnsupportedOperationException("不能有非数字的字符");
            if(result < multmin)
                throw new UnsupportedOperationException("字符串超限溢出");
            result *= 10;
            if(result  < digit + minValue)
                throw new UnsupportedOperationException("字符串超限溢出");
            result -= digit;
        }
        result = negative?result:-result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new STOI().strToInt("2147483647"));
    }
}
