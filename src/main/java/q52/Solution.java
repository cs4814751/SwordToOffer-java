package q52;

/**
 * Created by leibro on 2017/3/21.
 */
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int duplic = -1;
        for(int i = 0;i < length;i ++) {
            while(numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    duplic = numbers[i];
                    break;
                }
                swap(numbers,i,numbers[i]);
            }
            if(duplic >= 0)
                break;
        }
        if(duplic == -1)
            return false;
        else {
            duplication[0] = duplic;
            return true;
        }
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
