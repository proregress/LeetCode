/***
https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50
描述:
编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。

数据范围： 
1≤n≤500 

输入描述：
输入一行没有空格的字符串。
输出描述：
输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
***/

import java.util.Scanner;
import java.util.HashSet;

//ASCII的范围本来就是0-127，可以不判断
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        
        HashSet<Character> hs = new HashSet<Character>();
        for(int i=0; i<str.length(); i++){
            //hashset的去重原理：set用于存储不重复的元素集合
            hs.add(str.charAt(i)); //str.charAt(i) 获取字符串中i位置的字符
        }
        System.out.println(hs.size());
    }
}
