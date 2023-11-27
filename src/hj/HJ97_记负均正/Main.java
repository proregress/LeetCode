package hj.HJ97_记负均正;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while (in.hasNext()) { 
            int n = Integer.valueOf(in.nextLine());
            String str = in.nextLine();
            String[] chs = str.split(" ");
            int countNeg = 0; //负数的个数
            int countPos = 0; //正数的个数
            int sum = 0;      //正数的和
            for(String c : chs){
                if(Integer.valueOf(c) < 0){
                    countNeg = countNeg + 1;
                }else if(Integer.valueOf(c) > 0){
                    sum = sum + Integer.valueOf(c);
                    countPos = countPos + 1;
                }
            }
            if(countPos == 0){
                System.out.println(countNeg + " "+ 0.0);
            }else{
                System.out.println(countNeg + " "+ String.format("%.1f", sum * 1.0/ countPos));
            }
        }
           
    }
}
