package hj.HJ26_字符串排序;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){         
            String str = sc.nextLine();
            System.out.println(sort(str));
        }
    }
    
    public static String sort(String str){
        //先将英文字母收集起来
        ArrayList<Character> letters = new ArrayList<>();
        for(char c : str.toCharArray()){
            if(Character.isLetter(c)){
                letters.add(c);
            }
        }
        
        // 将英文字母先排序好:升序a-z
        letters.sort(new Comparator<Character>(){
            public int compare(Character o1, Character o2){
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        // 对原字符串str的每个字符进行判断：
        // （1）若是数字，则直接添加
        // （2）若是英文字母，则加入排好序的letters中的字符，按顺序加入即可。
        StringBuilder result = new StringBuilder();
        for(int i = 0, j = 0; i < str.length(); i++){
            if(Character.isLetter(str.charAt(i))){
                result.append(letters.get(j++));
            }else{
                result.append(str.charAt(i));
            }
        }
        return result.toString();
        
    }
    
}
