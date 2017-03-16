package q30;

/**
 * Created by leibro on 2017/3/16.
 */
public class Solution {
/*    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null)
            return 0;
        if(array.length == 0)
            return 0;
        return search(array,0,array.length - 1);
    }

    private int search(int[] array,int lo,int hi) {
        if(lo == hi)
            return array[lo];
        int j = partition(array,lo,hi);
        if(j == array.length / 2)
            return array[j];
        else if(j > array.length / 2) {
            int[] copy = new int[array.length];
            System.arraycopy(array,0,copy,0,array.length);
            return search(copy,lo,j - 1);
        }

        else {
            int[] copy = new int[array.length];
            System.arraycopy(array,0,copy,0,array.length);
            return search(copy,j + 1,hi);
        }
    }

    public int partition(int[] a,int lo,int hi) {
        int i = lo,j = hi;
        int v = a[lo];
        while (true) {
            while (a[++ i] < v)
                if(i == hi)
                    break;
            while (a[-- j] > v)
                if(j == lo)
                    break;
            if(i >= j)
                break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    private void exch(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }*/

    public static void main(String[] args) {
        int[] a = {1,2,3,2,4,2,5,2,3};
        System.out.print(new Solution().MoreThanHalfNum_Solution(a));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        int count = 0;
        int cur = Integer.MAX_VALUE;
        for(int i = 0;i < array.length;i ++) {
            if(count == 0) {
                cur = array[i];
                count++;
                continue;
            }
            if(cur == array[i])
                count ++;
            else
                count --;
        }
        if(count > 0) {
            if(verify(cur,array))
                return cur;
            else
                return 0;
        } else {
            return 0;
        }

    }

    private boolean verify(int cur,int[] array) {
        int count = 0;
        int threshold = array.length / 2;
        for(int i = 0;i < array.length;i ++) {
            if (array[i] == cur)
                count ++;
        }
        if(count > threshold)
            return true;
        else
            return false;
    }
}
