package bfs.L0752_打开转盘锁;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        openLock(null, null);
    }

    public static int openLock(String[] deadends, String target) {
        int step = 0;
        HashSet<String> visited  = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        HashSet<String> deadendsSet  = new HashSet<>();
        for(String s : deadends){
            deadendsSet.add(s);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                String poll = queue.poll();
                //判断是否到达target
                if(poll.equals(target)){
                    return step;
                }
                //判断是否遇上锁死
                if(deadendsSet.contains(poll)){
                    continue;
                }
                for(int j = 0; j < 4; j++){
                    String up = plusOne(poll, j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(poll, j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            /* 在这里增加步数 */
            //TODO： 为什么是在这里
            step++;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return -1;
    }

    /* 【**】处理向上拨一个的方法*/
    private static String plusOne(String poll, int i){
        char[] chars = poll.toCharArray();
        if(chars[i] == '9'){
            chars[i] = '0';
        }else{
            chars[i] += 1;
        }
        return new String(chars);

    }

    /* 【**】处理向下拨一个的方法*/
    private static String minusOne(String poll, int i){
        char[] chars = poll.toCharArray();
        if(chars[i] == '0'){
            chars[i] = '9';
        }else{
            chars[i] -= 1;
        }
        return new String(chars);
    }

}
