package twoPointers.slideWindow.L0003_无重复字符的最长子串;

public class Solution {
    /**
    滑的时候还是要脑子清楚一点，右边字符什么时候进什么时候出
     */
    public static int lengthOfLongestSubstring(String s) {
        int l = 0 , r = 0;
        String subStr = "";
        int ans = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            r++;
            if(subStr.indexOf(ch) >= 0){
                int index = subStr.indexOf(ch);
                l = index + 1;
                subStr = subStr + ch;
                subStr = subStr.substring(l);
            }else {
                subStr = subStr + ch;
            }
            ans = Math.max(ans, subStr.length());
        }

        return ans;
    }

    /*
    haha 错啦，s="" 时，直接错啦，还是要注意观察题目条件。
     */
    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;

        int l = 0 , r = 1;
        String subStr = s.substring(l,r);
        while(r < s.length()){
            String rStr = s.substring(r, r+1);
            if(subStr.contains(rStr)){
                int index = subStr.indexOf(rStr);
                l = index + 1;
                subStr = subStr.substring(l) + rStr;
            }else {
                subStr = subStr + rStr;
            }
            ans = Math.max(ans, subStr.length());
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "aab";
        int i = lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }
}
