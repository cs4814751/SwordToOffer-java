package q11;

/**
 * Created by leibro on 2017/3/7.
 */
public class Solution {
    public int JumpFloorII(int target) {
        if(target == 0)
            return 1;
        if(target == 1)
            return 1;
        return 2 * JumpFloorII(target - 1);
    }
}
