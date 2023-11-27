package hj.HJ40_统计字符;

/***
 方法一：使用Character.isLetter(char c)和Character.isDigit(char c)判断
 ***/
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            char[] chs = str.toCharArray();
            int letter = 0;
            int digit = 0;
            int blank = 0;
            int others = 0;
            for(char c : chs){
                if(Character.isLetter(c)){
                    letter++;
                }else if(Character.isDigit(c)){
                    digit++;
                }else if(c == ' '){
                    blank++;
                }else{
                    others++;
                }
            }
            System.out.println(letter);
            System.out.println(blank);
            System.out.println(digit);
            System.out.println(others);
        }
    }
}

