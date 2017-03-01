package q4;

/**
 * Created by leibro on 2017/3/1.
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        int spaceCnt = 0;
        for(int i = 0;i < oldLen;i ++) {
            if(str.charAt(i)== ' ')
                spaceCnt ++;
        }
        int newLen = oldLen + spaceCnt * 2;
        str.setLength(newLen);
        int p1 = oldLen - 1;
        int p2 = newLen - 1;
        while(p1 >= 0) {
            if(str.charAt(p1) != ' ') {
                str.setCharAt(p2 --,str.charAt(p1 --));
            } else {
                str.setCharAt(p2 --,'0');
                str.setCharAt(p2 --,'2');
                str.setCharAt(p2 --,'%');
                p1 --;
            }
        }
        return str.toString();
    }
}
