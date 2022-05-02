/***
方法一：双指针
***/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        while (sc.hasNext()) { 
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String s1 = str1.length() < str2.length()?str1 : str2; //short string
            String s2 = str1.length() < str2.length()?str2 : str1; //long string
            
            int n = 0;
            
            for(int i = 0; i<s1.length(); i++){           // 头指针从第一位开始递增
                for(int j = s1.length(); j>i; j--){       // 尾指针从最后一位开始缩减（注意边界
                    if(s2.contains(s1.substring(i,j))){   // 第一次发现合集的长度一定是最大的
                        n = j-i>n ? j-i : n;              // 取每一次比较的最大值
                        continue;                         // 已经是最大的，无需再进行后续的操作
                    }
                }
            }
            System.out.println(n);
        }
    }
}
