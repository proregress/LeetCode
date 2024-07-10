package 逻辑分析.HJ344_找座位;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int sum = 0 ;
        int index = line.indexOf("1");
        if(index == -1){
            //完全没有1，只有0
            System.out.println( (line.length()+1) / 2);
            return;
        }
        //0~1:0 , 2~3:1
        sum = sum + index / 2;
        line = line.substring(index+1);
        while (line.contains("1")){
            index = line.indexOf("1");
            //0~2:0 , 3~4:1
            if(index != 0){
                sum = sum + (index-1) / 2;
            }
            line = line.substring(index+1);
        }
        int zeroSize = line.length();
        //1000:1, 100000:2
        if(zeroSize != 0 ){
            sum = sum + zeroSize / 2;
        }
        System.out.println(sum);
    }
}
