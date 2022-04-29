/***
描述：
计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）

输入描述：
输入一行，代表要计算的字符串，非空，长度小于5000。

输出描述：
输出一个整数，表示输入字符串最后一个单词的长度。
***/

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //nextLine()方法：一次读取一行数据，只在回车符时终止录入
        String str  = sc.nextLine();
        //用空格分割为字符串数组
        String[] arr = str.split(" ");
        System.out.println(arr[arr.length-1].length());
    }
}
