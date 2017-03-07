package q10;

/**
 * Created by leibro on 2017/3/7.
 */
public class Solution {
    public int JumpFloor(int target) {
        return jumpFloor(target);
    }

    private int jumpFloor(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        return jumpFloor(n - 1) + jumpFloor(n - 2);
    }
}
