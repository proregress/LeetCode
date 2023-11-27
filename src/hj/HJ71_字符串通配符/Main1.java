package hj.HJ71_字符串通配符;

/***
一、注意事项
1.多个*与一个*的功能是相通的，所以进行replaceAll替换;
2.虽然字符串中构成复杂，但是依然可以用toLowerCase将大写字母全部替换成小写
3.判断索引是否等于长度值的原因：如果通过不停的++，索引已经等于长度了，而程序还一直没有返回false，则说明已经比到末尾了且都是匹配的，所以是true   
方法一：递归
***/
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String symbol = sc.nextLine().toLowerCase().replaceAll("\\*+","\\*"); //多个*与一个*的功能是相通的，所以进行replaceAll替换;
            String str = sc.nextLine().toLowerCase();//虽然字符串中构成复杂，但是依然可以用toLowerCase将大写字母全部替换成小写
            System.out.println(isMatch(str,symbol,0,0));
        }
    }
    //递归
    public static boolean isMatch(String str, String regex, int i, int j){
        //判断索引是否等于长度值的原因：如果通过不停的++，索引已经等于长度了，而程序还一直没有返回false，则说明已经比到末尾了且都是匹配的，所以是true
        if(i==str.length() && j==regex.length()){
            return true;
        }
        while(i<str.length() && j<regex.length()){
            // 若相等  //一开始还限定了都是字母/数字且相等，但这样的话无法通过（t?t*1*.*）（txt12.xls）此用例，原因：.也相等
            if(str.charAt(i)== regex.charAt(j)){
                i++;
                j++;
            //遇到？，则匹配1个字符
            }else if(regex.charAt(j) == '?' && Character.isLetterOrDigit(str.charAt(i))){
                i++;
                j++;
            //遇到*，则匹配0个或1个或多个
            }else if(regex.charAt(j)== '*'){
                return isMatch(str,regex,i,j+1) || isMatch(str,regex,i+1,j+1) || isMatch(str,regex,i+1,j);
            }else{
                break;   
            }
            //判断索引是否等于长度值的原因：如果通过不停的++，索引已经等于长度了，而程序还一直没有返回false，则说明已经比到末尾了且都是匹配的，所以是true
            if(i==str.length() && j==regex.length()){
                return true;
            }
        }
        return false;
    }
}

