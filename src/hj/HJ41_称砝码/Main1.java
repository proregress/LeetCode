package hj.HJ41_称砝码;

//暴力枚举，称出多少种不同的重量，用HashSet
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] weights = new int[n+1];
            int[] nums = new int[n+1];

            for(int i = 0; i < n; i++){
                weights[i] = sc.nextInt();
            }

            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }

            HashSet<Integer> set = new HashSet<>();
            set.add(0);

            for(int i = 0; i < n; i++){  //遍历砝码种类，分别是第一种、第二种、第三种...
                ArrayList<Integer> list = new ArrayList<>(set);  //将当前set的情况存进list中，以便稍后依次在当前size上加上新种砝码的不同个数情况
                for(int j = 1; j <= nums[i]; j++){  //遍历每种砝码的个数，分别是该种砝码放1个、2个、3个...的情况
                    for(int k = 0; k < list.size(); k++){  //在当前list的情况上加砝码
                        set.add(list.get(k) + weights[i] * j);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}


