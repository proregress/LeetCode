package hj.HJ82_将真分数分解为埃及分数;

/***算法描述

设某个真分数的分子为a，分母为b；
把b除以a的商p部分加1后的值作为埃及分数的某一个分母c=p+1；
将a-a%b，作为新的a；
将b乘以c，得到新的b；
··如果a大于1且能整除b，则最后一个分母为b/a；算法结束；
··或者，如果a等于1，则最后一个分母为b；算法结束；
否则重复上面的步骤。
***/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String str = sc.nextLine();
            System.out.println(solve(str));
        }
    }
    
    public static String solve(String str){
        String[] ss = str.split("/");
        long a = Long.parseLong(ss[0]); //分子为a  //不能是int型，否则部分用例无法通过
        long b = Long.parseLong(ss[1]); //分母为b  //不能是int型，否则部分用例无法通过
        
        StringBuilder result = new StringBuilder();
        
        while(a > 0){
            long c = b / a + 1;
            a = a - b % a;
            b = b * c;
            result.append("1/"+c+"+");
            
            if(a > 1 && b % a == 0){
                result.append("1/"+b/a);
                break;
            }
            if(a == 1){
                result.append("1/"+b);
                break;
            }
        }
        return result.toString();
        
    }
}
