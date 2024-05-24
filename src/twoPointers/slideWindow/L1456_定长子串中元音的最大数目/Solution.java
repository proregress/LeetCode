package twoPointers.slideWindow.L1456_定长子串中元音的最大数目;

public class Solution {
    public static int maxVowels(String s, int k) {
        int ans = 0;

        int l = 0, r = l + k;
        String subStr = s.substring(l,r);
        int sum = 0;
        for(char c : subStr.toCharArray()){
            if("aeuio".indexOf(String.valueOf(c)) >= 0){
                sum++;
            }
        }
        ans = sum;
        while(r < s.length()){
            if("aeuio".indexOf(String.valueOf(s.charAt(r))) >= 0){
                sum++;
            }
            if("aeuio".indexOf(String.valueOf(s.charAt(l))) >= 0){
                sum--;
            }
            r++;
            l++;
            ans = Math.max(ans, sum);
        }

        return ans;

    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        int i = maxVowels(s, k);
        System.out.println("i = " + i);
    }

}
