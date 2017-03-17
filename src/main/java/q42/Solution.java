package q42;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leibro on 2017/3/17.
 */
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 0)
            return;
        int res = diff(array);
        int pos = 0;
        for(int i = 0;;i ++) {
            if((res & (1 << i)) != 0) {
                pos = i;
                break;
            }
        }
        ArrayList<ArrayList<Integer>> groups = group(array,pos);
        int[] group1 = new int[groups.get(0).size()];
        int[] group2 = new int[groups.get(1).size()];
        transfer(group1,groups.get(0));
        transfer(group2,groups.get(1));
        int n1 = diff(group1);
        int n2 = diff(group2);
        num1[0] = n1;
        num2[0] = n2;
    }

    private void transfer(int[] a, List<Integer> list) {
        for(int i = 0;i < list.size();i ++)
            a[i] = list.get(i);
    }

    private ArrayList<ArrayList<Integer>> group(int[] array,int k) {
        ArrayList<Integer> group1 = new ArrayList<>();
        ArrayList<Integer> group2 = new ArrayList<>();
        for(int i = 0;i < array.length;i ++) {
            if((array[i] & (1 << k)) != 0)
                group1.add(array[i]);
            else
                group2.add(array[i]);

        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(group1);
        res.add(group2);
        return res;
    }

    private int diff(int[] array) {
        int res = array[0];
        for(int i = 1;i < array.length;i ++) {
            res = res ^ array[i];
        }
        return res;
    }
}
