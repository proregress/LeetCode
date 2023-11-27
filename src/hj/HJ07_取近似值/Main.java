package hj.HJ07_取近似值;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        // 需要自己获取输入的浮点数，因此选用java自带的Scanner类，并且初始化
        Scanner sc = new Scanner(System.in);
        float number = sc.nextFloat();
        //Math类有round方法，默认可以四舍五入，但是返回值为Long类型
        //Long类型也是整数值，可以不用强转int，可以直接输出
        int ans = (int)Math.round(number);
        System.out.println(ans);
    }
}
