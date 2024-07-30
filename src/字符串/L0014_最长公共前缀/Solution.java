package 字符串.L0014_最长公共前缀;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"a","ab"};
        String s = longestCommonPrefix(strs);
        System.out.println("s = " + s);
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];

        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            len = Math.min(len, str.length());
        }

        int index = 0;
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if(!flag) break;
            Character c = null;
            for(String str : strs) {
                char c1 = str.charAt(i);
                if(c != null && c != c1){
                    flag = false;
                    break;
                }
                c = c1;
            }
            if(flag) index++;
        }
        return strs[0].substring(0,index);
    }
}
