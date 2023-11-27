package hj.HJ08_合并表记录;
/***
利用TreeMap 不重复 & 有序的特性

1.声明map存放key-value
2.如果输入的key已经存在map中，更新value即可：map.put(j,map.get(j) + value);
3.如果输入的key不存在map中，则直接添加进去map:map.put(key,value)
4.最后输出map
***/
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        TreeMap<Integer,Integer> table = new TreeMap<>();
        
        for(int i = 0; i < n; i++){
            int key = sc.nextInt();
            int value = sc.nextInt();
            if(table.containsKey(key)){ 
                table.put(key,table.get(key)+value);
            }else{
                table.put(key,value);
            }
            //map.put(a,map.getOrDefault(a,0) + b);//用map自带的getOrDefault方法,如果根据key没有值,就用默认的0表示方法的值,如果能根据key找到对应的值,那么直接赋值
        }
        for(Integer key:table.keySet()){
            System.out.println(key+" " +table.get(key));
        }
    }
}

/***
描述：
数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
***/
