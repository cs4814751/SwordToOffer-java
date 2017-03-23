package q68;

/**
 * Created by leibro on 2017/3/23.
 */
public class Solution {
    private int count = 0;

    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] map = new boolean[rows][cols];
        movingCount(threshold,rows,cols,0,0,map);
        for(int i = 0;i < rows;i ++) {
            for(int j = 0;j < cols;j ++) {
                if(map[i][j] == true)
                    System.out.print(" ☺");
                else
                    System.out.print(" *");
            }
            System.out.println("");
        }
        return count;
    }

    private void movingCount(int threshold,int rows,int cols,int i,int j,boolean[][] map) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || map[i][j] == true)
            return;
        if(convert(i) + convert(j) > threshold)
            return;
        map[i][j] = true;
        count ++;
        movingCount(threshold,rows,cols,i + 1,j,map);
        movingCount(threshold,rows,cols,i - 1,j,map);
        movingCount(threshold,rows,cols,i,j + 1,map);
        movingCount(threshold,rows,cols,i,j - 1,map);
    }

    private int convert(int num) {
        int sum = 0;
        int bit = -1;
        for(int i = 1;(bit = (int)(num % Math.pow(10,i) / Math.pow(10,i - 1))) != 0;i ++) {
            sum += bit;
        }
        return sum;
    }
}
