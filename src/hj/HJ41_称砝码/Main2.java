package hj.HJ41_称砝码;

import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());  //n --- 砝码的种数(范围[1,10])
            String[] weight = sc.nextLine().split(" ");  //m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
            String[] num = sc.nextLine().split(" ");  //x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
            int[] weights = new int[n+1];
            int[] nums = new int[n+1];

            for(int i = 0; i<n; i++){
                weights[i] = Integer.parseInt(weight[i]);  //重量
                nums[i] = Integer.parseInt(num[i]);  //个数
            }

            HashSet<Integer> set = new HashSet<>();
            set.add(0);

            for(int i = 0; i < n; i++){  //遍历砝码
                ArrayList<Integer> list = new ArrayList<>(set);
                for(int j = 1; j <= nums[i]; j++){  //遍历个数
                    for(int k = 0; k < list.size(); k++){
                        set.add(list.get(k) + weights[i] * j);
                    }
                }

            }
            System.out.println(set.size());
        }
    }
}










