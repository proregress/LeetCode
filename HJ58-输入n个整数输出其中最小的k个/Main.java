import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) { 
            String[] str1 = in.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int k = Integer.parseInt(str1[1]);
            
            String[] arr = in.nextLine().split(" ");
            
            ArrayList<Integer> list = new ArrayList<>();
            for(String s : arr){
                list.add(Integer.parseInt(s));
            }
            
            Collections.sort(list);  //使用方法2
//             list.sort(Comparator.naturalOrder());// 使用方法1
            
            for(int i = 0; i < k; i++){
                System.out.print(list.get(i)+" ");
            }
            
        }
    }
}
