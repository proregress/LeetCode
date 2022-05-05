/***
方法三：使用正则表达式
***/
import java.util.*;
public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNextLine()) {
                String str = sc.nextLine();
                String str1 = str.replaceAll("[^a-zA-Z]", "");
                String str2 = str.replaceAll("[^ ]", "");
                String str3 = str.replaceAll("[^0-9]", "");
                String str4 = str.replaceAll("[a-zA-Z0-9 ]", "");
                System.out.println(str1.length());
                System.out.println(str2.length());
                System.out.println(str3.length());
                System.out.println(str4.length());
            }
        }
}

/***
方法一：使用Character.isLetter(char c)和Character.isDigit(char c)判断
***/
import java.util.Scanner;

public class Main {
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

/***
方法二：使用char c, (c>='a' && c<='z')||(c>='A' && c<='Z')判断
***/
import java.util.Scanner;

public class Main {
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

