package hj.HJ71_字符串通配符;

//方法二：正则表达式
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String regx = sc.nextLine().toLowerCase().replaceAll("\\*+","\\*"); //多个*与一个*的功能是相通的，所以进行replaceAll替换;
            String str = sc.nextLine().toLowerCase();//虽然字符串中构成复杂，但是依然可以用toLowerCase将大写字母全部替换成小写

            //做相应的替换
            regx = regx.replaceAll("\\?", "[0-9A-Za-z]{1}");
            regx = regx.replaceAll("\\*", "[0-9A-Za-z]{0,}");
//             regx = regx.replaceAll("\\.", "\\\\.");
            boolean result = str.matches(regx);
            System.out.println(result);
        }
    }

}
