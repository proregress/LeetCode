import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (sc.hasNext()) { // 注意 while 处理多个 case
            String str = sc.nextLine();
            
            char[] charArr = str.toCharArray();
            
            TreeMap<Character,Integer> map = new TreeMap<>();
            
            for(char c : charArr){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            
            //把map放入list中。
            ArrayList<Map.Entry> list = new ArrayList<>(map.entrySet());  
            //Override
            Collections.sort(list, new Comparator<Map.Entry>(){
               @Override
                public int compare(Map.Entry o1, Map.Entry o2){
                    if(o1.getValue() != o2.getValue()){
                        return (int)(o2.getValue()) - (int)(o1.getValue());
                    }else{
                        return (char)(o1.getKey()) - (char)(o2.getKey());
                    }
                }
            });
            
            for(Map.Entry entry : list){
                System.out.print(entry.getKey());
            }
            
         
        }
    }
}
