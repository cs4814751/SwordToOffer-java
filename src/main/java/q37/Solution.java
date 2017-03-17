package q37;

/**
 * Created by leibro on 2017/3/17.
 */
public class Solution {
    private int count = 0;
    private int[] aux;

    public int InversePairs(int [] array) {
        count = 0;
        aux = new int[array.length];
        sort(array,0,array.length - 1);
        return count % 1000000007;
    }

    private void sort(int[] a,int lo,int hi) {
        if(lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a,lo,mid);
        sort(a,mid + 1,hi);
        merge(a,lo,mid,hi);
    }

    private void merge(int[] a,int lo,int mid,int hi) {
        for(int i = lo;i <= hi;i ++)
            aux[i] = a[i];
        int lt = lo;
        int gt = mid + 1;
        for(int i = lo;i <= hi;i ++) {
            if(lt > mid) {
                a[i] = aux[gt++];

            }
            else if(gt > hi) {
                a[i] = aux[lt++];

            }
            else if(aux[lt] < aux[gt]) {
                a[i] = aux[lt++];

            }
            else {
                a[i] = aux[gt ++];
                if(count >= 1000000007)
                    count = count % 1000000007;
                count += mid - lt  + 1;

            }
        }
    }

    public static void main(String[] args) {
        int[] a = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(new Solution().InversePairs(a));
    }
}
