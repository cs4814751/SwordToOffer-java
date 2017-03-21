package q44;

import java.util.ArrayList;

/**
 * Created by leibro on 2017/3/20.
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int head = 0;
        int tail = array.length - 1;
        int minMutil = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        while(head < tail) {
            if(array[head] + array[tail] == sum) {
                if(array[head] * array[tail] < minMutil) {
                    minMutil = array[head] * array[tail];
                    res.clear();
                    res.add(array[head]);
                    res.add(array[tail]);
                }
                head ++;
                tail --;
            } else if(array[head] + array[tail] < sum) {
                head ++;
                continue;
            } else {
                tail --;
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,8,10};
        ArrayList<Integer> res = new Solution().FindNumbersWithSum(a,11);
    }
}
