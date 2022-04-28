/***
解法一：Integer.parseInt(String s,int 进制radix) : 将radix进制数s转换成十进制数并输出
***/

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            String str = sc.next();
            int ans = Integer.parseInt(str.substring(2),16);
            System.out.println(ans);
        }
    }
}
