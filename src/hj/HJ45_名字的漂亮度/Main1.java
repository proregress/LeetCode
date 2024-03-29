package hj.HJ45_名字的漂亮度;

/***
思路一：
1.从左到右依次遍历字符，统计每个字符的出现次数，以（字符：次数）的形式存进map中，并得到出现次数最大值max
2.用max依次和map中的value值比较，相等的话，给该字符赋值26，并加上值*出现次数（即max），赋值依次减1，max依次加1
（运行时间：100ms,超过22.22% 用Java提交的代码
占用内存：14352KB,超过12.29%用Java提交的代码）
***/
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            int n = Integer.parseInt(sc.nextLine());
            for(int i = 0 ; i<n; i++){
                String str = sc.nextLine();
                System.out.println(value(str));
            }
        }
    }
    
    public static int value(String str){
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs = str.toCharArray();
        int max = 0;
        for(char c : chs){
            map.put(c,map.getOrDefault(c,0)+1); //将每个字符和对应出现次数存储到map中
            max = Math.max(max,map.get(c));  //得到字符串中出现最多次数的值
        }
        
        int i = 0;
        while(max > 0){
            for(char c : map.keySet()){  //以alisia为例，map中存的是 a:2, l:1, i:2, s:1,max=2
                if(map.get(c) == max){
                    result = result + max * (26 - i);
                    i++;
                }
            }
            max--;
        }
        return result;
        
    }
    
}


