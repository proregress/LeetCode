package sort.customSorting.HJ362_智能成绩表;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] NM = sc.nextLine().split(" ");
        int n = Integer.valueOf(NM[0]);
        int m = Integer.valueOf(NM[1]);
        List<String> list = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        String[] studentList = new String[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            studentList[i] = s;
        }
        String byOrder = sc.nextLine();
        LinkedList<LinkedList<Object>> stuList = new LinkedList<>();
        int index = list.indexOf(byOrder);
        if(index != -1){
            //按照学科排
            for(String stu : studentList){
                String[] s = stu.split(" ");
                String name = s[0];
                Integer score = Integer.parseInt(s[index+1]);
                LinkedList<Object> student = new LinkedList<>();
                student.add(name);
                student.add(score);
                stuList.add(student);
            }
        }else {
            //按照总分排
            for(String stu : studentList){
                String[] s = stu.split(" ");
                String name = s[0];
                Integer score = 0;
                for (int i = 0; i < m; i++) {
                    score = score + Integer.valueOf(s[i+1]);
                }
                LinkedList<Object> student = new LinkedList<>();
                student.add(name);
                student.add(score);
                stuList.add(student);
            }
        }

        stuList.sort(new Comparator<LinkedList<Object>>() {
            @Override
            public int compare(LinkedList<Object> stu1, LinkedList<Object> stu2) {
                if((int)stu2.get(1) == (int)stu1.get(1)){
                    return ((String)stu1.get(0)).compareTo((String)stu2.get(0));
                }
                return (int)stu2.get(1) - (int)stu1.get(1);
            }
        });

        for(LinkedList<Object> stu : stuList){
            System.out.print(stu.get(0) + " ");
        }
    }
}
