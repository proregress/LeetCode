package hj.HJ57_高精度整数加法;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        while (sc.hasNext()) { 
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            char ch1;//此处不能用char[] ch1 和char[] ch2数组存储，因为下面会出现char[负数]的情况
            char ch2;//此处不能用char[] ch1 和char[] ch2数组存储，因为下面会出现char[负数]的情况
            int n = str1.length()-1;//str1的最后一位索引
            int m = str2.length()-1;//str2的最后一位索引
            
            StringBuilder result =  new StringBuilder();
            int carry = 0; //进位
            
            while(n >= 0 || m >= 0){
                if(n >= 0){
                    ch1 = str1.charAt(n); //ch1 = '0'
                    n--;
                }else{
                    ch1 = '0';
                }
                if(m >= 0){
                    ch2 = str2.charAt(m); //ch2 = '0'
                    m--;
                }else{
                    ch2 = '0';
                }
                /***两点：
                1. 第二次遇到这种通过字符char获得int的问题，两次解决方式都是一致的
                   该方式为char ch - '0';
                   上一次为找到字母表中某字母的索引index（i的范围为0-25）
                   方法为int index = char ch - 'a';
                2. 其实并不需要判断两个数字相加是否>=10,
                   每次append加的是对10取余的余数
                   carry为除10后的结果
                ***/
                if(ch1 - '0' + ch2 - '0' + carry >= 10){
                    result.append((ch1 - '0' + ch2 - '0' + carry) % 10); // result = 1, 还要进1
                    carry = (ch1 - '0' + ch2 - '0' + carry) / 10;
                }else{
                    result.append((ch1 - '0' + ch2 - '0' + carry) % 10); 
                    carry = (ch1 - '0' + ch2 - '0' + carry) / 10;
                }
            }
            //n和m都为0了，此时看是否还有进的1
            if(carry == 1){
                result.append(carry);
            }

            System.out.println(result.reverse().toString());
        }
    }
}
