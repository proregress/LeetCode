package hj.HJ37_统计每个月兔子的总数;

/***
 方法二：斐波那契数列：f(n) = f(n-1) + f(n-2)
 ***/
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            System.out.println(f(n));
        }
    }

    public static int f(int n){
        if(n == 1){         //定义初始条件1
            return 1;
        }else if(n == 2){    //定义初始条件2
            return 1;
        }else{
            return f(n-1)+f(n-2);  //定义斐波那契方程
        }
    }
}
