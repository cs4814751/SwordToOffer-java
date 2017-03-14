package q21;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leibro on 2017/3/14.
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int circle = ((row > col?row:col) - 1)/ 2 + 1;
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        while(col > start * 2 && row > start * 2) {
            PrintMatrixInCircle(result,row,col,start,matrix);
            start++;
        }
        return result;

    }

    private void PrintMatrixInCircle(List<Integer> result, int row, int col, int start, int[][] matrix) {
        int endX = row - start - 1;
        int endY = col - start - 1;

        for(int i = start;i <= endY;i ++)
            result.add(matrix[start][i]);
        if(start < endX) {
            for(int i = start + 1;i <= endX;i ++)
                result.add(matrix[i][endY]);
        }
        if(endX > start && endY > start) {
            for(int i = endY - 1;i >= start;i --)
                result.add(matrix[endX][i]);
        }
        if(endX - start >= 2 && endY > start) {
            for(int i = endX - 1;i > start;i --)
                result.add(matrix[i][start]);
        }
    }
}
