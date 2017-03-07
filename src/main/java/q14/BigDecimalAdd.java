package q14;

/**
 * Created by leibro on 2017/3/7.
 */
public class BigDecimalAdd {
    public String add(String s1,String s2) {
        sortMax(s1,s2);
        char[] arr1 = new StringBuilder(s1).reverse().toString().toCharArray();
        char[] arr2 = new StringBuilder(s2).reverse().toString().toCharArray();
        StringBuilder sb = new StringBuilder(arr1.length + 1);
        init(sb,arr1);
        return add(arr1,arr2,sb);
    }

    private String add(char[] arr1,char[] aar2,StringBuilder sb) {
        int over = 0;
        for(int i = 0;i < arr1.length;i ++) {
            over = afterAdd(arr1,aar2,over,i,sb);
        }
        return finalHandle(sb,over);
    }

    private int afterAdd(char[] arr1,char[] arr2,int over,int pos,StringBuilder sb) {
        char c1,c2;
        c1 = arr1[pos];
        if(pos < arr2.length) {
            c2 = arr2[pos];
        } else {
            c2 = '0';
        }
        int res = (c1 - '0') + (c2 - '0') + over;
        if(res < 10) {
            sb.setCharAt(pos,(char)('0' + res));
            return 0;
        } else {
            sb.setCharAt(pos,(char)('0' + res - 10));
            return 1;
        }
    }

    private void init(StringBuilder sb,char[] arr1) {
        for(int i = 0;i < sb.capacity();i ++)
            if(i >= arr1.length) {
                sb.insert(i, '0');
            } else {
                sb.insert(i,arr1[i]);
            }
    }

    private void sortMax(String s1,String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        String temp;
        if(len1 < len2) {
            temp = s1;
            s1 = s2;
            s2 = temp;
        }
    }

    private String finalHandle(StringBuilder sb,int over) {
        if(over == 1) {
            sb.setCharAt(sb.length() - 1,'1');
            return sb.reverse().toString();
        } else {
            return new StringBuilder(sb.substring(0, sb.length() - 1)).reverse().toString();
        }
    }

    public static void main(String[] args) {
        String num1 = "999999999999999999";
        String num2 = "99999999999999999";
        System.out.println(new BigDecimalAdd().add(num1,num2));
    }


}
