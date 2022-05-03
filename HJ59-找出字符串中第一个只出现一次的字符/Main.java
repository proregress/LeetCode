/***
一、双指针，i=0，j=i，依次往后遍历，遍历到末尾只出现一次则直接输出
二、contains
三、replaceAll: 已写本题
***/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String str = sc.nextLine();
            int len1 = str.length();
            char result = ' ';
            for(int i = 0; i <str.length(); i++){
                char ch = str.charAt(i);
                String str2 = str.replaceAll(String.valueOf(ch),"");
                int len2 = str2.length();
                if(len1-len2 == 1){
                    result = ch;
                    System.out.println(ch);
                    break;
                }
            }
            if(result == ' '){
                System.out.println(-1);
            }
        }
    }
}
