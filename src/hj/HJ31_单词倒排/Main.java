package hj.HJ31_单词倒排;
/***  2/26
一、思路
1.将非大小写字母的char全部替换成空格
    注意：只能用replace() 不能用replaceAll()
2.用split(" ")将string分隔进String[]
3.倒序输出

二、匹配非字母的字符进行分割
1.我的思路：将非字母字符全部替换成空格，再用空格分隔
2.其他：正则表达式[^a-zA-Z]分割：String[] words = str.split("[^A-Za-z]");

三、一些比较：
str = str.replace(String.valueOf(c)," ")时，运行时间:134ms，占用内存:17400KB
改为str = str.replace(c,' ')后               运行时间:48ms，占用内存:11548KB，提升30%多
***/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String str = sc.nextLine();
            char[] chs = str.toCharArray();
            for(char c : chs){
                if(!Character.isLetter(c)){
                    str = str.replace(c,' ');
                }
            }
            String[] strArr = str.split(" ");
            for(int i = strArr.length-1; i>=0; i-- ){
                System.out.print(strArr[i] + " ");
            }     
        }
        
    }
}
