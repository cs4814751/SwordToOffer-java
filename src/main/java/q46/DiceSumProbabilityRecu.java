package q46;

/**
 * Created by leibro on 2017/3/20.
 */
public class DiceSumProbabilityRecu {
    private void printProbability(int n) {
        int[] res= new int[n * 6 + 1];
        for(int i = 0;i < res.length;i ++)
            res[i] = 0;
        probability(n,res);
        for(int i = 1;i < res.length;i ++) {
            System.out.println(i + " %" + 100 * res[i] / (Math.pow(6,3)));
        }
    }

    private void probability(int goal,int[] res) {
        for(int i = 1;i <= 6;i ++) {
            dice(1,0,i,res,goal);
        }
    }

    private void dice(int cur,int preSum,int val,int[] res,int goal) {
        if(cur == goal) {
            int sum = preSum + val;
            res[sum] ++;
        } else {
            for(int i = 1;i <= 6;i ++)
                dice(cur + 1,preSum + val,i,res,goal);
        }
    }

    public static void main(String[] args) {
        new DiceSumProbabilityRecu().printProbability(3);
    }

}
