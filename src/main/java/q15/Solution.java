package q15;

/**
 * Created by leibro on 2017/3/7.
 */
public class Solution {
    public void reOrderArray(int [] array) {
        for(int i = 0;i < array.length;i ++) {
            for(int j = i;j > 0 && odd(array,j) && !odd(array,j - 1);j --)
                swap(array,j,j - 1);
        }
    }

    public boolean odd(int[] array,int n) {
        return array[n] % 2 == 1;
    }

    private void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
