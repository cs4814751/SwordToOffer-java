package q56;

/**
 * Created by leibro on 2017/3/21.
 */
import java.util.*;
public class Solution {
    int[] map = new int[256];
    ArrayList<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        list.add(ch);
        map[ch] ++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(char c:list) {
            if(map[c] == 1) {
                return c;
            }
        }
        return '#';
    }
}
