/***
正则做法：
***/
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
        String input = scanner.next();
        System.out.println(input.replaceAll("([0-9]+)", "*$1*")); //把所有的数字段提取出来，前后加上星号再放回去
    }
}



/*** 8/26 常规做法
运行时间：50ms
占用内存：10956KB
***/
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
//             char[] chs = str.toCharArray();
            StringBuilder result = new StringBuilder();
            for(int i = 0; i<str.length(); i++){
                //若不是数字，直接append
                if(!Character.isDigit(str.charAt(i))){
                    result.append(str.substring(i,i+1));
                //若是数字，先加*，接下来只要是数字就依次append，直到遇到不是数字，加*结束
                }else{
                    result.append("*");
                    while(i<str.length() && Character.isDigit(str.charAt(i))){
                        result.append(str.charAt(i));
                        i++;
                    }
                    result.append("*");
                    //在while结束前的最后一次循环中i已经指到了下一个非数字字符了，而for再自增一次，就跳过了该字符，所以需要在while结束之后减一
                    i--; //注意此处，不i--的话，带着此处的i的值重新进行if循环，会先i++，这会导致跳过一个字符
                }
            }
            System.out.println(result.toString());
        }
    }
}
