package q43;

import java.util.ArrayList;

/**
 * Created by leibro on 2017/3/20.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum < 3)
            return res;
        int s = (int)Math.sqrt(2 * sum);
        for(int i = s;i >= 2;i --) {
            if(2 * sum % i == 0) {
                int d = 2 * sum / i;
                if(d % 2 == 0 && i % 2 != 0 || d % 2 != 0 && i % 2 == 0) {
                    int a1 = (d - i + 1) / 2;
                    int an = (i + d - 1) / 2;
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int j = a1;j <= an;j ++) {
                        list.add(j);
                    }
                    res.add(list);
                }
            }
        }
        return res;
    }
}
