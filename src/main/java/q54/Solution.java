package q54;

/**
 * Created by leibro on 2017/3/21.
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        return matchCore(str,pattern,0,0);
    }

    private boolean matchCore(char[] str,char[] pat,int strIndex,int patIndex) {
        if(strIndex == str.length && patIndex == pat.length)
            return true;
        if(strIndex != str.length && patIndex == pat.length)
            return false;
        if(patIndex <= pat.length - 2 && pat[patIndex + 1] == '*') {
            if(strIndex < str.length && (str[strIndex] == pat[patIndex] || pat[patIndex] == '.'))
                return matchCore(str,pat,strIndex + 1,patIndex) ||
                        matchCore(str,pat,strIndex + 1,patIndex + 2) ||
                        matchCore(str,pat,strIndex,patIndex + 2);
            else
                return matchCore(str,pat,strIndex,patIndex + 2);
        } else {
            if(strIndex < str.length && (str[strIndex] == pat[patIndex] || pat[patIndex] == '.' ))
                return matchCore(str,pat,strIndex + 1,patIndex + 1);
        }
        return false;
    }

/*    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }*/


    public static void main(String[] args) {
        String s1 = "bbbba";
        String s2 = ".*a*a";
        System.out.println(new Solution().match(s1.toCharArray(),s2.toCharArray()));
    }
}
