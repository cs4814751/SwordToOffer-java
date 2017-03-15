package q29;

import java.util.ArrayList;

/**
 * Created by leibro on 2017/3/15.
 */
public class EightQueen {
    private ArrayList<int[]> list = new ArrayList<>();
    private ArrayList<int[]> result = new ArrayList<>();
    private int count = 0;

    public int eightQueen() {
        int[] colIndex = new int[8];
        for(int i = 0;i < colIndex.length;i ++) {
            colIndex[i] = i;
        }
        permutation(colIndex,0);
        for(int[] a:list) {
            if(verify(a))
                count ++;
        }
        for(int[] a:result) {
            print(a);
            System.out.println("-------------------------------");
        }
        return count;
    }

    private void permutation(int[] colIndex,int pos) {
        if(pos == colIndex.length - 1)
            list.add(colIndex);
        for(int i = pos;i < colIndex.length;i ++) {
            int[] copy = new int[colIndex.length];
            System.arraycopy(colIndex,0,copy,0,colIndex.length);
            swap(copy,pos,i);
            permutation(copy,pos + 1);
        }
    }

    private void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean verify(int[] a) {
        for(int i = 0;i < a.length;i ++) {
            for(int j = i + 1;j < a.length;j ++) {
                if(i - j == a[i] - a[j] || j - i == a[i] - a[j])
                    return false;
            }
        }
        result.add(a);
        return true;
    }

    private void print(int[] a) {
        for(int i = 0;i < a.length;i ++) {
            for(int j = 0;j < a.length;j ++) {
                if(j != a[i])
                    System.out.print(" *");
                else
                    System.out.print(" Q");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        System.out.println(new EightQueen().eightQueen());
    }


}
