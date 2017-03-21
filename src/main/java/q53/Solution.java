package q53;

/**
 * Created by leibro on 2017/3/21.
 */
public class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for(int i = 1;i < B.length;i ++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for(int j = B.length - 1;j >= 0;j --) {
            B[j] = B[j] * temp;
            temp *= A[j];
        }
        return B;
    }

    public static void main(String[] args) {
        new Solution().multiply(new int[]{1,2,3,4,5});
    }
}
