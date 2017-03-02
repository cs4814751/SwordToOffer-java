package q8;

/**
 * Created by leibro on 2017/3/2.
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int p1 = 0;
        int p2 = array.length - 1;
        if(array[p1] < array[p2]) {
            return array[p1];
        }
        while(p2 - p1 != 1) {
            int mid = (p1 + p2) / 2;
            if(array[p1] == array[p2] && array[p1] == array[mid]) {
                return sequenceFind(array,p1,p2);
            } else {
                if(array[p1] <= array[mid]) {
                    p1 = mid;
                    continue;
                } else if(array[p2] >= array[mid] ) {
                    p2 = mid;
                    continue;
                }
            }
        }
        return array[p2];
    }

    private int sequenceFind(int[] array,int p1,int p2) {
        int min = Integer.MAX_VALUE;
        for(int i = p1;i <= p2;i ++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
