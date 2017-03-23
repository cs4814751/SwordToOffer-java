package q67;

/**
 * Created by leibro on 2017/3/23.
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for(int i = 0;i < rows;i ++) {
            for(int j = 0;j < cols;j ++) {
                boolean[] map = new boolean[matrix.length];
                initMap(map);
                if(hasPath(matrix,rows,cols,str,map,i,j,0))
                    return true;
            }
        }
        return false;
    }

    public boolean hasPath(char[] matrix,int rows,int cols,char[] str,boolean[] map,int i,int j,int pos) {
        boolean res = false;
        if(pos == str.length)
            return true;
        if(i >= rows || i < 0 || j >= cols || j < 0 || map[convert(i,j,rows,cols)] == true)
            return false;
        if(str[pos] != matrix[convert(i,j,rows,cols)])
            return false;
        map[convert(i,j,rows,cols)] = true;
        res = hasPath(matrix,rows,cols,str,map,i + 1,j,pos + 1) ||
                hasPath(matrix,rows,cols,str,map,i - 1,j,pos + 1) ||
                hasPath(matrix,rows,cols,str,map,i,j + 1,pos + 1) ||
                hasPath(matrix,rows,cols,str,map,i,j - 1,pos + 1);
        return res;
    }

    private int convert(int i,int j,int rows,int cols) {
        return i * cols + j;
    }

    private void initMap(boolean[] map) {
        for(int i = 0;i < map.length;i ++)
            map[i] = false;
    }

    public static void main(String[] args) {
        String a = "ABCESFCSADEE";
        String b = "SEE";
        new Solution().hasPath(a.toCharArray(),3,4,b.toCharArray());
    }
}
