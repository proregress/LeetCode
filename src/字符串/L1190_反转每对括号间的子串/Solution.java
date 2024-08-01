package 字符串.L1190_反转每对括号间的子串;

/**
 * 同：L0394_字符串解码
 */
public class Solution {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        String res = reverseParentheses(s);
        System.out.println("res = " + res);
    }
    public static String reverseParentheses(String s) {
       if(s.length() == 1) return s;

       while(s.indexOf(')') != -1){
           int r = s.indexOf(')');
           int l = 0;
           StringBuilder sb = new StringBuilder();
           for (int i = r-1; i >= 0 ; i--) {
               if(s.charAt(i) == '('){
                   l = i;
                   break;
               }
               sb.append(s.charAt(i));
           }
           String subStr = sb.toString();
           s = s.substring(0,l) + subStr + s.substring(r+1);
       }

       return s;
    }
}
