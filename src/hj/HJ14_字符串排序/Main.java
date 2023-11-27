package hj.HJ14_字符串排序;
//此题注意nextInt()、next()、nextLine()的用法，很容易出错

/***
* 字符串排序(按照字典排序)
     * 解题思路
     * 1.先获取正整数N（N需要排序字符串的个数）
     * 2.定义空数组，长度为N
     * 3.循环接收输入的字符串并装入数组中
     * 4.用数组的Array.sort(ary)方法排序
     * 5.循环输出数组中的字符串。
***/

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();//nextInt()执行后光标停在读取到的int之后，但本行并未结束，还有换行符没有读取。两种解决方法，1.使用nextInt之后使用nextLine手动换行。即在第十行后面加上一行：sr.nextLine();2后面读取数据保持跟nextInt一致，如使用next或其他如nextDouble等。
        String[] arr = new String[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        for(String s:arr){
              System.out.println(s);
        }
    }
}


/***题目：
描述：
给定 n 个字符串，请对 n 个字符串按照字典序排列。

数据范围： 
1≤n≤1000  ，字符串长度满足 1≤len≤100 
***/
