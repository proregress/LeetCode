package hj.HJ02_计算某字符出现次数;

/***
描述:
写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）

数据范围： 
1≤n≤1000

输入描述：
第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
输出描述：
输出输入字符串中含有该字符的个数。（不区分大小写字母）
***/

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 接受第一次输入的长字符串,并转换为小写
        String str1 = sc.nextLine().toLowerCase();
        // 接受单个字符，并转换为小写
        String str2 = sc.nextLine().toLowerCase();
        
        int length1 = str1.length();
        int length2 = str1.replaceAll(str2,"").length();
        
        System.out.println(length1 - length2);
    }
}
