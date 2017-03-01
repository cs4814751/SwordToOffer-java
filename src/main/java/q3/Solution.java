package q3;

/**
 * Created by leibro on 2017/3/1.
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int column = array[0].length;
        int i = column - 1;
        int j = 0;
        while (j < row && i >= 0) {
            if(array[j][i] < target) {
                j ++;
                continue;
            } else if(array[j][i] > target) {
                i --;
                continue;
            } else {
                return true;
            }
        }
        return false;
    }
}