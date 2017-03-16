package q36;

/**
 * Created by leibro on 2017/3/16.
 */
public class Solution {
    private int[] alphabet = new int[256];

    public int FirstNotRepeatingChar(String str) {
        char f = 0;
        if(str == null)
            return -1;
        if(str.length() == 0)
            return -1;
        for(int i = 0;i < str.length();i ++) {
            char c = str.charAt(i);
            alphabet[c] ++;
        }
        for(int i = 0;i < str.length();i ++) {
            char c = str.charAt(i);
            if(alphabet[c] == 1)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "google";
        System.out.print(new Solution().FirstNotRepeatingChar(s));

    }


}
