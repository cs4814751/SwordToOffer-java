package q45;

/**
 * Created by leibro on 2017/3/20.
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0)
            return "";
        int k = n % str.length() - 1;
        str = reverse(str,0,k);
        str = reverse(str,k + 1,str.length() - 1);
        str = reverse(str,0,str.length() - 1);
        return str;

    }

    private String reverse(String s,int i,int j) {
        StringBuilder sb = new StringBuilder(s);
        int head = i;
        int tail = j;
        while(head < tail) {
            swap(sb,head ++,tail --);
        }
        return sb.toString();
    }

    private void swap(StringBuilder sb,int i,int j) {
        char a = sb.charAt(i);
        char b = sb.charAt(j);
        sb.setCharAt(i,b);
        sb.setCharAt(j,a);
    }
}
