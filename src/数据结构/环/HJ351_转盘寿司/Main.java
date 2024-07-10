package 数据结构.环.HJ351_转盘寿司;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int size = s.length;
        int[] priceArr = new int[size];
        int[] nextCheaper = new int[size];
        for (int i = 0; i < size; i++) {
            priceArr[i] = Integer.valueOf(s[i]);
        }
        List<Integer> prices = Arrays.stream(priceArr).boxed().collect(Collectors.toList());
        for (int i = 0; i < size; i++) {
            for(int j = i+1; j < size+i+1; j++){
                if(priceArr[j % size] < priceArr[i]){
                    nextCheaper[i] = priceArr[j%size];
                    break;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(nextCheaper[i] + priceArr[i] + " ");
        }
    }
}

