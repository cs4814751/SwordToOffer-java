package q35;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leibro on 2017/3/16.
 */
public class Solution {
    private LinkedList<Integer> uglys = new LinkedList<>();

    public int GetUglyNumber_Solution(int index) {
        if(index == 0)
            return 0;
        int t2 = 0,t3 = 0,t5 = 0;
        uglys.add(1);
        while(uglys.size() < index) {
            int m2 = uglys.get(t2) * 2;
            int m3 = uglys.get(t3) * 3;
            int m5 = uglys.get(t5) * 5;
            int m = m2 < m3?(m2 < m5?m2:m5):(m3 < m5?m3:m5);
            uglys.add(m);
            t2 = adjustT1(t2,m);
            t3 = adjustT3(t3,m);
            t5 = adjustT5(t5,m);
        }
        return uglys.peekLast();
    }

    private int adjustT1(int t2,int m) {
        while(uglys.get(t2) * 2 <= m)
            t2 ++;
        return t2;
    }

    private int adjustT3(int t3,int m) {
        while (uglys.get(t3) * 3 <= m)
            t3 ++;
        return t3;
    }

    private int adjustT5(int t5,int m) {
        while (uglys.get(t5) * 5 <= m)
            t5 ++;
        return t5;
    }

    public static void main(String[] args) {
        int a = new Solution().GetUglyNumber_Solution(20);
        System.out.print(a);
    }
}
