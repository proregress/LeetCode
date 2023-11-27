package hj.HJ73_计算日期到天数转换;

/***
知识点：
判断是否是闰年:
1.非整百年份：能被4整除的是闰年。（如2004年就是闰年，2001年不是闰年）
2.整百年份：能被400整除的是闰年。（如2000年是闰年，1900年不是闰年）
***/import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { 
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int year = Integer.valueOf(s[0]);
            int month = Integer.valueOf(s[1]);
            int day = Integer.valueOf(s[2]);
            
            HashMap<Integer,Integer> monthMap = new HashMap<>();
            monthMap.put(1,0);
            monthMap.put(2,31);
            monthMap.put(3,59);
            monthMap.put(4,90);
            monthMap.put(5,120);
            monthMap.put(6,151);
            monthMap.put(7,181);
            monthMap.put(8,212);
            monthMap.put(9,243);
            monthMap.put(10,273);
            monthMap.put(11,304);
            monthMap.put(12,334);
            HashMap<Integer,Integer> monthMapRun = new HashMap<>();
            monthMapRun.put(1,0);
            monthMapRun.put(2,31);
            monthMapRun.put(3,60);
            monthMapRun.put(4,91);
            monthMapRun.put(5,121);
            monthMapRun.put(6,152);
            monthMapRun.put(7,182);
            monthMapRun.put(8,213);
            monthMapRun.put(9,244);
            monthMapRun.put(10,274);
            monthMapRun.put(11,305);
            monthMapRun.put(12,335);
            
            int result = 0;
            
            //判断是否是闰年
            //非整百年份：能被4整除的是闰年。（如2004年就是闰年，2001年不是闰年）
            if(year % 100 != 0){
                if(year % 4 == 0){
                    result = monthMapRun.get(month) + day;
                }else{
                    result = monthMap.get(month) + day;
                }
            //整百年份：能被400整除的是闰年。（如2000年是闰年，1900年不是闰年）
            }else{
                if(year % 400 == 0){
                    result = monthMapRun.get(month) + day;
                }else{
                    result = monthMap.get(month) + day;
                }
            }
            System.out.println(result);
        }
    }
}
