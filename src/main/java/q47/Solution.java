package q47;

/**
 * Created by leibro on 2017/3/20.
 */
public class Solution {
    public boolean isContinuous(int [] numbers) {
        bubbleSort(numbers);
        int zeros = countZero(numbers);
        int gaps = countGaps(numbers);
        if(gaps == -1)
            return false;
        if(zeros >= gaps)
            return true;
        else
            return false;
    }

    public void bubbleSort(int[] num) {
        for(int i = num.length - 1;i > 0;i --) {
            for(int j = 0;j < i;j ++) {
                if(num[j] > num[j + 1])
                    swap(num,j,j + 1);
            }
        }
    }

    private void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int countZero(int[] numbers) {
        int count = 0;
        for(int i = 0;i < numbers.length;i ++)
            if(numbers[i] == 0)
                count ++;
        return count;
    }

    private int countGaps(int[] numbers) {
        int count = 0;
        int pos = 0;
        for(int i = 0;i < numbers.length && numbers[i] == 0;i ++)
            pos ++;
        for(int i = pos;i < numbers.length - 1;i ++) {
            if(numbers[i] == numbers[i + 1])
                    return -1;
            count += numbers[i + 1] - numbers[i] - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution().isContinuous(new int[]{0,3,2,6,4});
    }
}
