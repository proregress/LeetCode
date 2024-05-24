package twoPointers.slideWindow.L1456_定长子串中元音的最大数目;

public class Solution {
    public static int maxVowels(String s, int k) {
        int ans = 0;

        // 定长k，左边界l=0, 从左至右依次遍历
        for(int l = 0 ; l + k <= s.length(); l++){
            int temp = 0;
            //得到定长为k的子串
            String subStr = s.substring(l, l+k);
            //对子串的每个字符判断，得到元音数量
            for(char c : subStr.toCharArray()){
                /**
                 * 使用indexOf判断是否存在
                 */
//                if("aeuio".contains(String.valueOf(c))){
                if("aeuio".indexOf(String.valueOf(c)) > 0){
                    temp++;
                }
            }
            ans = Math.max(ans, temp);
        }

        return ans;

    }

    public static void main(String[] args) {
        String s = "weallloveyou";
        int k = 7;
        int i = maxVowels(s, k);
        System.out.println("i = " + i);
    }
}
