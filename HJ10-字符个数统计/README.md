[题目](https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50)

#### hashset的去重原理：set用于存储不重复的元素集合
  - 将元素添加进Set<E>：boolean add(E e)
  - 将元素从Set<E>删除：boolean remove(Object e)
  - 判断是否包含元素：boolean contains(Object e)
  
```
import java.util.HashSet;
public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true
        System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
        System.out.println(set.contains("xyz")); // true，元素存在
        System.out.println(set.contains("XYZ")); // false，元素不存在
        System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
        System.out.println(set.size()); // 2，一共两个元素
    }
} 
  ```

  
#### Integer.valueOf(char) //在内部把字符char转化成ASCII的整型值
  
#### str.charAt(i)  //str.charAt(i) 获取字符串中i位置的字符
            
#### ASCII的范围：0-127
