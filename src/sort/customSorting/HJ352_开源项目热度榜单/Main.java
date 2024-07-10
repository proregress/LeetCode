package sort.customSorting.HJ352_开源项目热度榜单;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        int[] weight = new int[5];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < 5; i++) {
            weight[i] = Integer.valueOf(s[i]);
        }
        LinkedList<LinkedList<Object>> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split(" ");
            String name = str[0];
            int score = Integer.valueOf(str[1]) * weight[0]
                    + Integer.valueOf(str[2]) * weight[1]
                    + Integer.valueOf(str[3]) * weight[2]
                    + Integer.valueOf(str[4]) * weight[3]
                    + Integer.valueOf(str[5]) * weight[4];
            LinkedList<Object> proj = new LinkedList<>();
            proj.add(name);
            proj.add(score);
            list.add(proj);
        }

        list.sort(new Comparator<LinkedList<Object>>() {
            @Override
            public int compare(LinkedList<Object> p1, LinkedList<Object> p2) {
                if((int)p2.get(1) == (int)p1.get(1)){
                    return ((String)p1.get(0)).toLowerCase().compareTo(((String)p2.get(0)).toLowerCase());
                }
                return (int)p2.get(1) - (int)p1.get(1);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(0) + " ");
        }
    }
}
