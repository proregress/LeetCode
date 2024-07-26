package 字符串.L0394_字符串解码;

/**
 * 思路：首先找到第一个右括号，根据第一个右括号的index向左排查，找到与其对应的左括号
 * 这样能够定位到[] 和[] 前面的数字，通过循环+拼接+替换，完成局部替换
 * 一直循环以上过程
 */
public class Solution {
    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String ans = decodeString(s);
        System.out.println("ans = " + ans);
    }
    public static String decodeString(String s) {
        while(s.indexOf(']') != -1){
            int right = s.indexOf(']');
            int left = -1;
            int numberIndex = 0;
            for(int i = right; i >= 0; i--){
                if(s.charAt(i) == '['){
                    left = i;
                    for(int j = left-1; j >= 0; j--){
                        if(!Character.isDigit(s.charAt(j))){
                            numberIndex = j+1;
                            break;
                        }
                    }
                    break;
                }
            }
            int number = Integer.valueOf(s.substring(numberIndex,left));
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < number; j++){
                sb.append(s.substring(left+1, right));
            }
            String newStr = s.substring(0, numberIndex) + sb.toString() + s.substring(right+1);
            s = newStr;
        }
        return s;
    }

}
