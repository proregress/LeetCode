package hj.HJ29_字符串加解密;
//A --> a : ASCII + 32;
//A --> a : 通过字符加减实现: 'a' = 'A' - 'A' + 'a';
//char-int-String之间的转换：字母char 加减 int数字， 得到相应的ASCII码，前面再加上（char），转成改ASCII对应的字母
//判断是否为大小写还可以用：if(ch[i]>='A' && ch[i]<'Z')， if(ch[i]>='a' && ch[i]<'z')，更简单
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();
            
            StringBuilder result1 = new StringBuilder();
            StringBuilder result2 = new StringBuilder();
            
            //要加密
            for(char c : ch1){
                //9
                if(c == '9'){
                    result1.append(0);
                }else if(c == 'Z'){
                    result1.append('a');
                }else if(c == 'z'){
                    result1.append('A');
                //Character.isDigit() 判断是否为数字
                }else if(Character.isDigit(c) && c != '9'){
                    result1.append((char)(c+1));
                //Character.isLetter() 判断是否为字母 
                }else if(Character.isLetter(c) && c != 'z' && c != 'Z'){
                    //lowerCase or upperCase
                    String tempC = String.valueOf(c).toLowerCase();
                    if(tempC.equals(String.valueOf(c))){        //则c为小写
                        result1.append((char)(c-32+1));
                    }else{                 //则c为大写
                        result1.append((char)(c+32+1));
                    }
                }
            }
            //要解密
            for(char c : ch2){
                //9
                if(c == '0'){
                    result2.append(9);
                }else if(c == 'A'){
                    result2.append('z');
                }else if(c == 'a'){
                    result2.append('Z');
                //Character.isDigit() 判断是否为数字
                }else if(Character.isDigit(c) && c != '0'){
                    result2.append((char)(c-1));
                //Character.isLetter() 判断是否为字母 
                }else if(Character.isLetter(c) && c != 'a' && c != 'A'){
                    //lowerCase or upperCase
                    String tempC = String.valueOf(c).toLowerCase();
                    if(tempC.equals(String.valueOf(c))){        //则c为小写
                        result2.append((char)(c-32-1));
                    }else{                 //则c为大写
                        result2.append((char)(c+32-1));
                    }
                }
            }
            System.out.println(result1);
            System.out.println(result2);
        }
    }
}
