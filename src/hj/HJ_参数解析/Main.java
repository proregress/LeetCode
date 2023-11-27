package hj.HJ_参数解析;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextLine()) { 
            String str = sc.nextLine();
            char[] c = str.toCharArray();
            ArrayList<String> arrList = new ArrayList<>();
            String temp = "";
            
            boolean isLeft = false;
            for(int i = 0; i<str.length();i++){
                //判断为左引号
                if(c[i] == '\"' && !isLeft){
                    isLeft = true;
                    continue;
                }
                //判断为右引号
                if(c[i] == '\"' && isLeft){
                    isLeft = false;
                    continue;
                }
                //遇到正常空格,说明该加进arrList中了
                if(c[i] == ' ' && !isLeft){
                    arrList.add(temp);
                    temp = "";
                    continue;
                }   
                //遇到引号内空格
                if(c[i] == ' ' && isLeft){
                    temp = temp + c[i];
                    continue ;
                }
                temp = temp + c[i];
            }
            arrList.add(temp);
            System.out.println(arrList.size());
            for(String s : arrList){
                System.out.println(s);
            }
            
        }
    }
}
