package hj.HJ40_统计字符;

/***
 方法三：使用正则表达式
 ***/
import java.util.*;
public class Main3 {
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
