package hj.HJ54_表达式求值;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String str = sc.nextLine();
            System.out.println(solve(str));
        }
    }
    
    public static int solve(String str){
        str = str.replace(" ", "");// 去除所有空格
        str = str.replace("{", "(");//将大括号花括号全部转换为小括号
        str = str.replace("[", "(");
        str = str.replace("}", ")");
        str = str.replace("]", ")");
        
        Stack<Integer> stack = new Stack<>();
        
        int number = 0; //记录数字
        char sign = '+'; //记录每个数字前的符号，初始为+
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            //如果当前字符是数字
            if(c >= '0' && c <= '9'){
                number = number * 10 + (c - '0');
            }
            //如果当前字符是小括号
            if(c == '('){
                int j=i+1; //移到小括号后一位字符
                int count=1; //统计括号的数量
                while(count>0){
                    if(str.charAt(j) == ')') count--;  //遇到右括号，括号数-1
                    if(str.charAt(j) == '(') count++;   //遇到左括号，括号数+1
                    j++;
                }
                number=solve(str.substring(i+1,j-1));//递归，解小括号中的表达式
                i=j-1;
            }
            //如果当前字符是运算符，将number处理后放入栈
            if(!Character.isDigit(c) || i == str.length()-1){
                if(sign == '+'){
                    stack.push(number);
                }else if(sign == '-'){
                    stack.push(-1 * number);
                }else if(sign == '*'){
                    stack.push(stack.pop()*number);
                }else if(sign == '/'){
                    stack.push(stack.pop()/number);
                }
                 sign = c;
                 number = 0;
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans = ans + stack.pop();
        }
        return ans;
    }
}
