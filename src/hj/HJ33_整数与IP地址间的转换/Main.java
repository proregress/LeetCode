package hj.HJ33_整数与IP地址间的转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String str1 = sc.nextLine(); //10.0.3.193
            String str2 = sc.nextLine(); //167969729
            String result1 = new String();
            String result2 = new String();
            //1.将ip地址转换为10进制的数字串
            String longBiStr = "";                //用于存放ip地址转化为的01长整数
            String[] arr = str1.split("\\.");     //关键"\\."
            for(String s : arr){
                int temp = Integer.valueOf(s);                    //将String类型转换为int类型： Integer.valueOf()
                //将十进制转换成二进制
                String tempBi = Integer.toString(temp,2);         
                while(tempBi.length()<8){                         //补全0
                    tempBi = "0" + tempBi;
                }
                longBiStr = longBiStr + tempBi;  //得到ip地址转化为的01长整数
            }
            //将二进制转为十进制数
            result1 = Long.parseLong(longBiStr,2)+"";
            
            
            //2.将10进制的数字串转换为ip地址
            //将10进制转成2进制：String str = Long.toBinaryString(long l); str->long: long l = Long.parseLong(String s)
            String longBiStr2 = Long.toBinaryString(Long.parseLong(str2));
            while(longBiStr2.length()<32){                //补全0至32位
                longBiStr2 = "0"+longBiStr2;
            }
            String p1 = longBiStr2.substring(0,8);        //每8位进行分隔
            String p2 = longBiStr2.substring(8,16);
            String p3 = longBiStr2.substring(16,24);
            String p4 = longBiStr2.substring(24,32);
            //将2进制转成10进制：
            result2 = Long.parseLong(p1,2)+"."+Long.parseLong(p2,2)+"."+
                Long.parseLong(p3,2)+"."+Long.parseLong(p4,2);
            System.out.println(result1);
            System.out.println(result2);
        }
    }
}
