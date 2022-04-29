/***
第一个自己写出来的（查了一些method，看了最后一块的思路
思路：
1.用sc.next()或sc.nextInt()得到这4个关键词：n、n个单词、目标单词targetWord、k
2.将n个单词放进数组中
3.遍历存放了n个单词的数组，每个单词与targetWord相比较，长度不一致或两个单词相同时直接跳过（注：判断相同用.equals())
4.其他单词和targetWord，用.toCharArray()转换成char[]数组，并用Arrays.sort(char[]) 进行升序排列
5.比较两个升序排列后的char[]数组是否相同，用new String(sCharArr).equals(new String(targetCharArr))) （注意此处！ 还可以用Arrays.equals(sCharArr,targetCharArr)）
6.相同则将这个单词使用add()方法加入到List中（建立List：List<String> broWordList = new ArrayList<>();
7.全部加入后返回List.size()
8.用Collections.sort(List)将List升序排列
9.判断是否能取到k，能的话直接输出
***/
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            String str = sc.next();
            arr[i] = str;  
        }
         
        String targetWord = sc.next();
        int k = Integer.valueOf(sc.next());
        int length = targetWord.length();
        
        List<String> broWordList = new ArrayList<>();
        
        for(String s : arr){
            if(s.length() != length){
                continue;
            }
            if(s.equals(targetWord)){
                continue;
            }
            char[] sCharArr = s.toCharArray();
            char[] targetCharArr = targetWord.toCharArray();
            Arrays.sort(sCharArr);
            Arrays.sort(targetCharArr);
            if(new String(sCharArr).equals(new String(targetCharArr))){ //注意此处！ 还可以用Arrays.equals(sCharArr,targetCharArr)
                broWordList.add(s);
            }
            
        }
        System.out.println(broWordList.size());
//         broWordList.sort();//错
        Collections.sort(broWordList);
        
        if(broWordList.size()<=k){
            System.out.println("");
        }else{
            System.out.println(broWordList.get(k-1));
        }
    }
}
