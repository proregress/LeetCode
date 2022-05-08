import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String str = sc.nextLine();
            str = str.replace(" ",""); //去除所有空格
            str = str.replace("{","(");//把大括号花括号换成小括号
            str = str.replace("[","(");
            str = str.replace("]",")");
            str = str.replace("}",")");
            
            System.out.println(solve(str));
        }
    }
    
    public static int solve(String str){
        char sign = '+'; //记录每个数字前的符号，初始为+
        int number = 0; //记录数字
        Stack<Integer> stack = new Stack<>(); 
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            //如果指向了数字，处理得到number
            if(Character.isDigit(c)){
                number = number * 10 + (c - '0');
            }
            //如果指向了左括号，准备递归
            if(c == '('){
                int j = i+1;
                int count = 1;  //记录'(’的数量
                while(count > 0 && j < str.length()){
                    if(str.charAt(j) == '('){
                        count++;
                    }else if(str.charAt(j) == ')'){
                        count--;
                    }
                    j++;
                }
                number = solve(str.substring(i+1,j-1)); // 递归完成，得到括号内的运算结果
                i = j-1; //注意这里要将i更新至右括号
                
            }
            
            //如果指向了运算符, 或者指向了整个字符串的最后一位，说明应该对目前的number进行处理
            if(!Character.isDigit(c) || i == str.length()-1){
                if(sign == '+'){
                    stack.push(number);
                }else if(sign == '-'){
                    stack.push(-1 * number);
                }else if(sign == '*'){
                    stack.push(stack.pop() * number);
                }else if(sign == '/'){
                    stack.push(stack.pop() / number);
                }
                //处理完number后，更新sign和number//sign必须在if-else之后处理，否则如果遇到的是大小括号处理不到就会被跳过，sign一直保持为'('
                sign = c;
                number = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result;
    }
}
