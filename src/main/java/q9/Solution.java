package q9;

/**
 * Created by leibro on 2017/3/4.
 */
public class Solution {
    public int Fibonacci(int n) {
        return fib(n);
    }

//    private int fib(int n) {
//        if(n == 0)
//            return 0;
//        if(n == 1)
//            return 1;
//        if(n == 2)
//            return 1;
//        return fib(n - 1) + fib(n - 2);
//    }

    private int fib(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if (n == 2)
            return 1;
        int i = 3;
        int p1 = 1;
        int p2 = 1;
        int sum = 0;
        while (i <= n) {
            sum = p1 + p2;
            p1 = p2;
            p2 = sum;
            i ++;
        }
        return sum;
    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println(new Solution().Fibonacci(39));
        System.out.println(System.currentTimeMillis() - now);
    }
}
