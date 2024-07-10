package 逻辑分析.HJ343_最长子字符串的长度;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int count = 0; // o的个数
        for (int i = 0; i < length; i++) {
            if(str.charAt(i) == 'o'){
                count++;
            }
        }

        if(count % 2 == 0){
            //如果是偶数个o，则直接返回字符长度
            System.out.println(length);
        }else {
            //如果是奇数个o，则返回字符串长度-1
            // 原因：奇数个o，需要减去一个o。字符串首尾衔接，相当于可以固定任意一个o后转起来
            System.out.println(length-1);
        }
    }
}
