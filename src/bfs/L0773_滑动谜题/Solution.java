package bfs.L0773_滑动谜题;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] board = {{1,2,3},{5,4,0}};
        int step = slidingPuzzle(board);
        System.out.println(step);
    }

    public static int slidingPuzzle(int[][] board) {
        int step = 0;
        List<Integer> target = Arrays.asList(1,2,3,4,5,0);
        List<Integer> start = new ArrayList<>();
        for (int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                start.add(board[i][j]);
            }
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                List<Integer> poll = queue.poll();
                //如果找到target了，返回步数
                if(poll.equals(target)){
                    return step;
                }
                int index = poll.indexOf(0);
                switch (index){
                    case 0:
                        List<Integer> list1 = exchange(poll, 0, 1);
                        List<Integer> list2 = exchange(poll, 0, 3);
                        if(!visited.contains(list1)){
                            queue.offer(list1);
                            visited.add(list1);
                        }
                        if(!visited.contains(list2)){
                            queue.offer(list2);
                            visited.add(list2);
                        }
                        break;
                    case 1:
                        List<Integer> list3 = exchange(poll, 1, 0);
                        List<Integer> list4 = exchange(poll, 1, 2);
                        List<Integer> list5 = exchange(poll, 1, 4);
                        if(!visited.contains(list3)){
                            queue.offer(list3);
                            visited.add(list3);
                        }
                        if(!visited.contains(list4)){
                            queue.offer(list4);
                            visited.add(list4);
                        }
                        if(!visited.contains(list5)){
                            queue.offer(list5);
                            visited.add(list5);
                        }
                        break;
                    case 2:
                        List<Integer> list6 = exchange(poll, 2, 1);
                        List<Integer> list7 = exchange(poll, 2, 5);
                        if(!visited.contains(list6)){
                            queue.offer(list6);
                            visited.add(list6);
                        }
                        if(!visited.contains(list7)){
                            queue.offer(list7);
                            visited.add(list7);
                        }
                        break;
                    case 3:
                        List<Integer> list8 = exchange(poll, 3, 0);
                        List<Integer> list9 = exchange(poll, 3, 4);
                        if(!visited.contains(list8)){
                            queue.offer(list8);
                            visited.add(list8);
                        }
                        if(!visited.contains(list9)){
                            queue.offer(list9);
                            visited.add(list9);
                        }
                        break;
                    case 4:
                        List<Integer> list10 = exchange(poll, 4, 1);
                        List<Integer> list11= exchange(poll, 4, 3);
                        List<Integer> list12= exchange(poll, 4, 5);
                        if(!visited.contains(list10)){
                            queue.offer(list10);
                            visited.add(list10);
                        }
                        if(!visited.contains(list11)){
                            queue.offer(list11);
                            visited.add(list11);
                        }
                        if(!visited.contains(list12)){
                            queue.offer(list12);
                            visited.add(list12);
                        }
                        break;
                    case 5:
                        List<Integer> list13 = exchange(poll, 5, 2);
                        List<Integer> list14 = exchange(poll, 5, 4);
                        if(!visited.contains(list13)){
                            queue.offer(list13);
                            visited.add(list13);
                        }
                        if(!visited.contains(list14)){
                            queue.offer(list14);
                            visited.add(list14);
                        }
                        break;
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 交换数值
     * @param poll
     * @param a
     * @param b
     * @return
     */
    private static List<Integer> exchange(List<Integer> poll, int a, int b){
        //注意，这里每次都应该new一个新的对象返回出去
        ArrayList<Integer> list = new ArrayList<>(poll);
        Integer i = poll.get(a);
        Integer j = poll.get(b);
        list.set(a,j);
        list.set(b,i);
        return list;
    }
}
