package hj.HJ04_字符串分隔;
/***
描述：
•输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

输入描述：
连续输入字符串(每个字符串长度小于等于100)

输出描述：
依次输出所有分割后的长度为8的新字符串
***/

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //判断有无输入用sc.hasNextLine().接收字符串使用sc.nextLine()
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            //输出时，截取前8位进行输出，并更新字符串。用到str.substring()函数
            //（1）str.substring(i)意为截取从字符索引第i位到末尾的字符串
            //（2）str.substring(i,j)意为截取索引第i位到第（j-1）位字符串。包含i，不包含j
            while(str.length() > 8){
                System.out.println(str.substring(0,8));
                str = str.substring(8);
            }
            while(str.length() < 8 && str.length() > 0){
                str = str + "0";
            }
             System.out.println(str);
        }    
    }
}
