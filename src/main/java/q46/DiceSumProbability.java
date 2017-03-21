package q46;

/**
 * Created by leibro on 2017/3/20.
 */
public class DiceSumProbability {
    public void printProbability(int num) {
        int[][] record = new int[2][];
        record[0] = new int[num * 6 + 1];
        record[1] = new int[num * 6 + 1];
        for (int i = 0; i < num * 6 + 1; i++) {
            record[0][i] = 0;
            record[1][i] = 0;
        }
        int flag = 0;
        for (int i = 1; i <= 6; i++) {
            record[0][i] = 1;
        }

        for(int i = 2;i <= num;i ++) {
            for(int j = 0;j < i;j ++)
                record[1 - flag][j] = 0;
            for(int j = i;j <= num * 6;j ++) {
                record[1 -flag][j] = 0;
                for(int k = 1;k <= j && k <= 6;k ++)
                    record[1 -flag][j] += record[flag][j - k];
            }
            flag = 1 -flag;
        }
        for(int i = 1;i <= num * 6;i ++) {
            System.out.println(i + " %" + 100 * record[flag][i] / (Math.pow(6,3)));
        }
    }

    public static void main(String[] args) {
        new DiceSumProbability().printProbability(3);
    }


}
