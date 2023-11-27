package hj.HJ65_查找两个字符串ab中的最长公共子串;

/*
         * f[i][j]表示以str1第i个字符和str2第j个字符为结尾的公共子串的最大长度。
         * 分两种情况讨论。
         * 1、当str1(i)!=str2(j)时，结尾字符不同，所以以str1第i个字符和str2第j个字符为结尾的公共子串的最大长度为0,f[i][j]=0；
         * 2、当str1(i)==str2(j)时，结尾字符相同，所以f[i][j]=f[i-1][j-1]+1.
         * 初始条件：
         * f[0][j]=0,f[i][0]=0;
         * */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String s1 = sc.nextLine();
            String s2 = sc.nextLine(); 
            String str1 = s1;
            String str2 = s2;
            if(s1.length() > s2.length()){
                str1 = s1.length() > s2.length() ? s2 : s1; //short
                str2 = s1.length() < s2.length() ? s2 : s1; //long
            }
            int len1 = str1.length();
            int len2 = str2.length();
            
            int[][] dp = new int[len1+1][len2+1];
            
            for(int i = 0; i < len1; i++){
                dp[i][0] = 0;
            }
            for(int i = 0; i < len2; i++){
                dp[0][i] = 0;
            }
            int max = 0;
            int index = 0;
            for(int i = 1; i <= len1; i++){
                for(int j = 1; j <= len2; j++){
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = 0;
                    }
                    //更新记录最大值以及结尾索引
                    if(dp[i][j] > max){
                        max = dp[i][j];
                        index = i;
                    }
                }
            }
            System.out.println(str1.substring(index-max,index));
        }
    }
}
