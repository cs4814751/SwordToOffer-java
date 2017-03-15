package q29;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by leibro on 2017/3/15.
 */
public class Solution {
    private ArrayList<String> list = new ArrayList<>();
    private TreeSet<String> strings = new TreeSet<>();
    public ArrayList<String> Permutation(String str) {
        permutation(str,0);
        return new ArrayList<>(strings);
    }

    public void permutation(String str,int pos) {
        if(pos == str.length() - 1) {
            strings.add(str);
            return;
        }
        for(int i = pos;i < str.length();i ++) {
            str = swap(str,pos,i);
            permutation(str,pos + 1);
        }
    }

    private String swap(String str,int i,int j) {
        StringBuilder sb = new StringBuilder(str);
        char a = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,a);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> strings = new Solution().Permutation(s);
    }
}
