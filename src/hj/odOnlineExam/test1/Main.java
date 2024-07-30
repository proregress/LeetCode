package hj.odOnlineExam.test1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split("[,.;' ]");
        String prefix = sc.nextLine();

        LinkedList<String> result = new LinkedList<>();
        for(String s : split){
            if(s.startsWith(prefix)){
                if(!result.contains(s)){
                    result.add(s);
                }
            }
        }

        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        if(result.size() > 0){
            for(String s : result){
                System.out.print(s + " ");
            }
        }else {
            System.out.println(prefix);
        }
    }
}
