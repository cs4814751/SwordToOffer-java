package q25;

/**
 * Created by leibro on 2017/3/14.
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return verify(sequence,0,sequence.length - 1);
    }

    private boolean verify(int[] a,int i,int j) {
        if(i == j)
            return true;
        if(j - i == 1 && a[j] > a[i])
            return true;
        boolean is = true;
        int root = a[j];
        int p = i - 1;
        for(int m = i;m < j;m ++) {
            if(a[m] < root) {
                p++;
            } else {
                break;
            }
        }
        if(p == i - 1) {
            for(int m = p + 1;m < j;m ++) {
                if(a[m] < root)
                    return false;
            }
            return verify(a,i,j - 1);
        }
        if(p == j - 1)
            return verify(a,i,j - 1);

        for(int m = p + 1;m < j;m ++) {
            if(a[m] < root)
                return false;
        }
        is = verify(a,i,p);
        if(is)
            is = verify(a,p + 1,j - 1);
        return is;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,6,12,8,16,14,10};
        new q25.Solution().verify(a,0,6);
    }
}
