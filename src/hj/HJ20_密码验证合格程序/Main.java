package hj.HJ20_密码验证合格程序;
/***
1.判断字符串中是否包含某种类型的字符的4种方法，详见README.md
2.条件3思路：不能有长度大于2的包含公共元素的子串重复，即只需要判断重复3字符的子串即可
3.运行时间：42ms
占用内存：10868KB
***/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String str = sc.nextLine();
            System.out.println(isValidKey(str));
        }
    }
    
    public static String isValidKey(String str){
        //1.长度超过8位
        if(str.length() <= 8){
            return "NG";
        //2.四种符号至少三种
        }else{
//             int upperLetter = str.contains("[A-Z]") ? 1 : 0;
//             int lowerLetter = str.contains("[a-z]") ? 1 : 0;
//             int digit = str.contains("[0-9]") ? 1 : 0;
//             int symbol = str.contains("[^a-zA-Z0-9]") ? 1 : 0;
            int upperLetter = 0;
            int lowerLetter = 0;
            int digit = 0;
            int symbol = 0;
            for(int i = 0; i<str.length(); i++){
                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    upperLetter = 1;
                    continue;
                }
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                    lowerLetter = 1;
                    continue;
                }
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    digit = 1;
                    continue;
                }else{
                    symbol = 1;
                }
            }
            int sum = upperLetter+lowerLetter+digit+symbol;
            if(sum < 3){
                return "NG";
            //3.不能有长度大于2的包含公共元素的子串重复:判断重复3字符的子串即可
            }else{
                for(int i = 0; i+3<str.length(); i++){
                    String temp = str.substring(i,i+3);
                    if(str.substring(i+1).contains(temp)){
                        return "NG";
                    }
                }
            }
            
        }
        return "OK";
    }
}
