/** 3/26
运行时间:48ms
占用内存:10956KB
**/
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            System.out.println(strArr);
            
            
        }
    }
}
