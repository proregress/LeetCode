package 队列.L0406_根据身高重建队列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] == o1[0]) return o1[1] -o2[1];
                return o2[0] - o1[0];
            }
        });

        LinkedList<int[]> result = new LinkedList<>();
        for(int[] person : people){
            result.add(person[1], person);
        }
        return result.toArray(new int[result.size()][]);
    }
}
