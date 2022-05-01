/***思路: 动态规划的最长上升子序列LIS的变形
（1）计算出每个同学左边最多有几个人满足从左到右依次增大的序列要求（包括自己）。
示例：186 186 150 200 160 130 197 200
      1   1   1   2   2   1   3   4
动态方程：
（2）计算出每个同学右边最多有几个人满足从右到左依次增大的序列要求（包括自己）。
示例：186 186 150 200 160 130 197 200
      3   3   2   3   2   1   1   1
动态方程：
（3）将左右最多序列人数相加减一（自己加了两遍），就得到以该数为中心时，所在队列最多人数。
然后依次算出所有的队列的最多人数，然后与总人数相减，其中最小值就是最少剔除人数。
总人数-该数所在队列人数=需要出队的人数
***/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        while (sc.hasNextInt()) { 
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
//                 System.out.print(arr[i] + " ");
            }
            
            
            int[] left = new int[n];//存储每个数左边小于其的数的个数
            int[] right = new int[n];//存储每个数右边小于其的数的个数
            left[0] = 1;            //最左边的数设为1
            right[n-1] = 1;         //最右边的数设为1
            
            //计算每个位置左侧的最长递增
            for(int i = 0; i<n; i++){
                left[i] = 1;
                for(int j = 0; j<i; j++){
                    //动态规划
                    if(arr[j] < arr[i]){
                        left[i] = Math.max(left[j]+1,left[i]);
                    }
                }     
            }
             //计算每个位置右侧的最长递减
            for(int i = n-1; i>=0; i--){
                right[i] = 1;
                for(int j=n-1; j>i; j--){
                    //动态规划
                    if(arr[i] > arr[j]){
                        right[i] = Math.max(right[i],right[j]+1);
                    }
                }
            }
            //记录每个位置的值
            int[] result = new int[n];
            for(int i = 0; i<n; i++){
                result[i] = left[i] + right[i] - 1;
            }
            
            ///找到最大的满足要求的值
            int max = 1;
             for(int i = 0; i<n; i++){
                 max = Math.max(result[i],max);
             }
            
            System.out.println(n - max);
            
        
            
        }
    }
}
