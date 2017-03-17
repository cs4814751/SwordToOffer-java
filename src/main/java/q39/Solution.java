package q39;

/**
 * Created by leibro on 2017/3/17.
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0 || k < 0)
            return 0;
        int last = getLastK(array,0,array.length - 1,k);
        int first = getFirstK(array,0,array.length - 1,k);
        if(last == -1 || first == -1)
            return 0;
        return  last - first + 1 ;
    }

    private int getFirstK(int[] a,int lo,int hi,int k) {
        int mid = lo + (hi - lo) / 2;
        if(mid < lo || mid > hi)
            return -1;
        if((a[mid] == k && mid == 0 ) || (a[mid] == k && a[mid - 1] != k))
            return mid;
        else if(a[mid] == k && a[mid - 1] == k) {
            return getFirstK(a,lo,mid - 1,k);
        } else if(a[mid] < k) {
            return getFirstK(a,mid + 1,hi,k);
        } else if(a[mid] > k) {
            return getFirstK(a,lo,mid - 1,k);
        }
        return -1;
    }


    private int getLastK(int[] a,int lo,int hi,int k) {
        int mid = lo + (hi - lo) / 2;
        if(mid < lo || mid > hi)
            return -1;
        if((a[mid] == k && mid + 1 == a.length) || (a[mid] == k && mid + 1 < a.length && a[mid + 1] != k))
            return mid;
        else if(a[mid] == k && mid + 1 < a.length && a[mid + 1] == k) {
            return getLastK(a,mid + 1,hi,k);
        } else if(a[mid] < k) {
            return getLastK(a,mid + 1,hi,k);
        } else if(a[mid] > k) {
            return getLastK(a,lo,mid - 1,k);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1,1,1};
        System.out.print(new Solution().GetNumberOfK(a,3));
    }
}
