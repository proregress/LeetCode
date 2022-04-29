/***
描述：
功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）

输入描述：
输入一个整数

输出描述：
按照从小到大的顺序输出它的所有质数的因子，以空格隔开。

链接：https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607
***/
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long k = (long)Math.sqrt(num);  //如果循环到num会超时间限制，所以循环至其根号。。定理：一个正整数最多有一个质因子大于其平方根，且只会是其本身
        
        //使用双层循环
        //外层从2到根号num
        //内层循环寻找质因数
        for(long i=2; i<=k; i++){   // 短除法：不断除i，直到num的值为1为止
            while(num % i == 0){
                System.out.print(i + " ");
                num = num / i;
            }
        }
        //注意此句
        System.out.print(num == 1?"":num+"");
    }
}
