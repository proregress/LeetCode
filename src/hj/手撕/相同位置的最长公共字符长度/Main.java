package hj.手撕.相同位置的最长公共字符长度;

/**
 * 面试官口述：
 * 两个字符串，abcd，ab，有以下5种对齐方式：
 *   abcde   abcde    abcde    abcde    abcde    abcde
 * ace      ace       ace       ace       ace       ace
 * 第二种对齐方式相同位置字符相等的数量最多为2，因此答案为2
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int ans = getAns(s1, s2);
        System.out.println("ans = " + ans);
    }
    public static int getAns(String s1, String s2){
        int ans = Integer.MIN_VALUE;
        for(int j = -(s2.length()-1); j < s1.length(); j++){
            int count = 0;
            int k = j;
            for(int i = 0 ; i < s2.length(); i++){
                if(k >= 0 && k < s1.length()) {
                    if(s2.charAt(i) == s1.charAt(k)){
                        count++;
                    }
                }
                k++;
            }
            ans = Math.max(count,ans);
        }

        return ans;
    }
}
