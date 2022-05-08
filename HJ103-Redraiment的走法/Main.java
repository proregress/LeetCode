//最长上升子序列LIS
//dp[i] = max(dp[i]，dp[j]+1) , i > j且i处的值大于j处的值
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            int n = Integer.parseInt(sc.nextLine());
            String[] strArr = sc.nextLine().split(" ");
            int[] arr = new int[n+1];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(strArr[i]);
            }
            
            int[] dp = new int[n+1]; //数组dp存储对应位置i的最大次数，因此默认为1，因为当前桩本身就是一步
            int max = 1;
            
            for(int i = 0; i < n; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(arr[i] > arr[j]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }  
                }
                max = Math.max(dp[i],max);
            }
            System.out.println(max);
        }
    }
}
