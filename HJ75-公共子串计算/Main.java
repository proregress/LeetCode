/***
方法一：双指针
***/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        while (sc.hasNext()) { 
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String s1 = str1.length() < str2.length()?str1 : str2; //short string
            String s2 = str1.length() < str2.length()?str2 : str1; //long string
            
            int n = 0;
            
            for(int i = 0; i<s1.length(); i++){           // 头指针从第一位开始递增
                for(int j = s1.length(); j>i; j--){       // 尾指针从最后一位开始缩减（注意边界
                    if(s2.contains(s1.substring(i,j))){   // 第一次发现合集的长度一定是最大的
                        n = j-i>n ? j-i : n;              // 取每一次比较的最大值
                        continue;                         // 已经是最大的，无需再进行后续的操作
                    }
                }
            }
            System.out.println(n);
        }
    }
}
\
/*
方法二：动态规划
         * f[i][j]表示以str1第i个字符和str2第j个字符为结尾的公共子串的最大长度。
         * 分两种情况讨论。
         * 1、当str1(i)!=str2(j)时，结尾字符不同，所以以str1第i个字符和str2第j个字符为结尾的公共子串的最大长度为0,f[i][j]=0；
         * 2、当str1(i)==str2(j)时，结尾字符相同，所以f[i][j]=f[i-1][j-1]+1.
         * 初始条件：
         * f[0][j]=0,f[i][0]=0;
         * */
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int m = str1.length();
            int n = str2.length();
            
            int max = 0;
            
            int[][] dp = new int[m+1][n+1];
            
            for(int i = 0; i<=m; i++){
                for(int j = 0; j<=n; j++){
                    if(i==0 || j==0){
                        dp[i][j] = 0;
                    }else{
                        if(str1.charAt(i-1) != str2.charAt(j-1)){
                            dp[i][j] = 0;
                        }else{
                            dp[i][j] = dp[i-1][j-1] + 1;
                        }
                    }
                    max = Math.max(max,dp[i][j]);
                }
            }
            
            System.out.println(max);
            
        }
    }
}
