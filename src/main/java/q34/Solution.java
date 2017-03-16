package q34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by leibro on 2017/3/16.
 */
public class Solution {
    List<String> list = new ArrayList<>();

    public String PrintMinNumber(int [] numbers) {
        for(int i:numbers) {
            String s = String.valueOf(i);
            list.add(s);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s:list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
