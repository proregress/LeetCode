package binarySearch.HJ353_机器人搬砖;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int size = s.length;
        if(size > 8) {
            System.out.println(-1);
            return;
        }
        int[] bricks = new int[size];
        for (int i = 0; i < size; i++) {
            bricks[i] = Integer.valueOf(s[i]);
        }
        List<Integer> brickList = Arrays.stream(bricks).boxed().collect(Collectors.toList());
        Collections.sort(brickList);
        int max = brickList.get(size-1);
        int lo = 1, hi = max;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int hours = 0;
            for(int brick : bricks){
                int hour;
                if(brick <= mid){
                    hour = 1;
                }else {
                    int i = brick / mid;
                    int mod = brick % mid;
                    hour = i + (mod == 0 ? 0 : 1);
                }
                hours += hour;
            }
            if(hours > 8){
                lo = mid+1;
            }else if(hours <= 8){
                hi = mid-1;
            }
        }
        System.out.println(lo);
    }
}
