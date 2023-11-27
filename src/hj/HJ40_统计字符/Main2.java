package hj.HJ40_统计字符;

/***
 方法二：使用char c, (c>='a' && c<='z')||(c>='A' && c<='Z')判断
 ***/
import java.util.Scanner;

public class Main2 {
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
                if((c>='a' && c<='z')||(c>='A' && c<='Z')){
                    letter++;
                }else if(c>='0' && c<='9'){
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

