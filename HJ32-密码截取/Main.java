import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String s = sc.nextLine();
            
            int  len = s.length();
            int maxLen = 1;
            // 特判
            if(len < 2){
                maxLen = len;
            }else{
                maxLen = 1;
                
                // 1. 状态定义: 对比两个字符索引起始位置i和终止位置j
                // dp[i][j] 表示s[i...j] 是否是回文串
                
                // 2. 初始化
                boolean[][] dp =new boolean[len][len];
                //3. base case
                for(int i=0; i<len; i++){
                    dp[i][i] = true;
                }
                
                char[] chars = s.toCharArray();
                // 4. 内外循环
                for(int j = 1; j<len; j++){
                    for(int i = 0; i<j; i++){
                        // 状态转移：如果左右两字符相等,同时[l+1...r-1]范围内的字符是回文子串
                        // 则 [l...r] 也是回文子串
                        if(chars[i]==chars[j] && (j-i<3 || dp[i+1][j-1])){
                            dp[i][j] = true;
                            // 只要dp[i][j] == true 成立，则表示s[i...j] 是回文串
                            // 此时更新记录回文长度和起始位置
                            maxLen = Math.max(maxLen,j-i+1);
                        }
                    }
                }
                System.out.println(maxLen);
  
            }
        }
    }
}


