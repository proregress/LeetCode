package 数据结构.栈.HJ340_提取字符串中的最长合法简单数学表达式;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        // 合法的表达式只包含0-9和-+*，且操作符不能连续
        String line = sc.nextLine();
        for(int i = 0 ; i < line.length(); i++){
            char ch = line.charAt(i);
            int j = i+1;
            if(Character.isDigit(ch)){
                while (j < line.length()){
                    if(Character.isDigit(line.charAt(j))){
                        j++;
                    }else if(isSimple(line.charAt(j)) && j+1 < line.length()
                            && Character.isDigit(line.charAt(j+1))){
                        j++;
                    }else{
                        break;
                    }
                }
                String sub = "";
                if(i-1 >= 0 && line.charAt(i-1) == '-'){
                    sub = line.substring(i-1,j);
                    i = j-1;
                }else {
                    sub = line.substring(i,j);
                    i = j - 1;
                }
                strings.add(sub);
            }
        }

        int maxLen = -1;
        int res= 0;
        for (int i = 0; i < strings.size(); i++) {
            int length = strings.get(i).length();
            if(length > maxLen){
                //计算表达式的值
                res = calculate(strings.get(i));
                maxLen = length;
            }
        }
        System.out.println(res);
    }

    public static int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        int num = 0 ;
        char preSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            if(!Character.isDigit(ch) || i == s.length()-1){
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()){
            ans = ans + stack.pop();
        }
        return ans;
    }

    public static boolean isSimple(char ch){
        if(ch == '+' || ch == '-' || ch =='*') return true;
        return false;
    }
}
