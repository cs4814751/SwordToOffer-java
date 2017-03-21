package q45;

/**
 * Created by leibro on 2017/3/20.
 */
public class ReverseWord {

    public String reverseWord(String s) {
        s = reverse(s,0,s.length() - 1);
        int p = -1;
        for(int i = 0;i < s.length();) {
            while(s.charAt(i) != ' ' && i != s.length() - 1)
                i ++;
            if(i == s.length() - 1)
                s = reverse(s,p + 1,i);
            else
                s = reverse(s,p + 1,i - 1);
            p = i ++;
        }
        return s;
    }

    private String reverse(String s,int i,int j) {
        StringBuilder sb = new StringBuilder(s);
        int head = i;
        int tail = j;
        while(head < tail) {
            swap(sb,head ++,tail --);
        }
        return sb.toString();
    }

    private void swap(StringBuilder sb,int i,int j) {
        char a = sb.charAt(i);
        char b = sb.charAt(j);
        sb.setCharAt(i,b);
        sb.setCharAt(j,a);
    }

    public static void main(String[] args) {
        String s = "I am a student.";
        System.out.print(new ReverseWord().reverseWord(s));
    }
}
