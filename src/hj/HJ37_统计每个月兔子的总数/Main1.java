package hj.HJ37_统计每个月兔子的总数;

/***
 方法一：斐波那契数列：f(n) = f(n-1) + f(n-2)
 ***/
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = 1;
            for(int i = 2; i<n; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
            System.out.println(arr[n-1]);
        }
    }
}
