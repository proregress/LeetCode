package dfs.HJ314_解密犯罪时间;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<LinkedList<Integer>> legalTimeList = new LinkedList<>();
    static LinkedList<LinkedList<Integer>> allTimeList = new LinkedList<>();

    public static void main(String[] args) {
        String ans = "";
        int min = Integer.MAX_VALUE;

        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(":");
        char[] hh = split[0].toCharArray();
        char[] mm = split[1].toCharArray();
        int h1 = hh[0] - '0';
        int h2 = hh[1] - '0';
        int m1 = mm[0] - '0';
        int m2 = mm[1] - '0';
        int[] arr = new int[]{h1,h2,m1,m2};
        // h1,h2,m1,m2四个数字的全排列，每个数字都可以重复使用
        LinkedList<Integer> track = new LinkedList<>();
        dfs(arr,track);
        //得到legalTimeList，比较大小，得到比提供的时间大的最小时间
        for(LinkedList<Integer> time : legalTimeList){
            int legalTimeInt = time.get(0)*1000 + time.get(1) * 100 + time.get(2) * 10 + time.get(3);
            int currentTime = h1 * 1000 + h2 * 100 + m1 * 10 + m2;
            if(legalTimeInt > currentTime){
                min = Math.min(min, legalTimeInt);
            }
        }
        //说明是23：59
        if(min == Integer.MAX_VALUE){
            min = 2222;
        }
        String res = String.valueOf(min);
        if(res.length() == 4){
            System.out.println(res.substring(0,2) + ":" + res.substring(2));
        }else {
            System.out.println("0" + res.substring(0,1) + ":" + res.substring(1));
        }
    }

    public static void dfs(int[] arr, LinkedList<Integer> track){
        if(track.size() == 4){
            allTimeList.add(new LinkedList<>(track));
            if(isLegalTime(track)){
                legalTimeList.add(new LinkedList<>(track));
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            track.add(arr[i]);
            dfs(arr, track);
            track.removeLast();
        }
    }

    public static boolean isLegalTime(LinkedList<Integer> track){
        int h1 = track.get(0);
        int h2 = track.get(1);
        int m1 = track.get(2);
        int m2 = track.get(3);
        if(h1<0 || h1>2) return false;
        if(m1<0 || m1>5) return false;
        if(m2<0) return false;
        if(h1==2 && h2>3) return false;
        return true;
    }

}
