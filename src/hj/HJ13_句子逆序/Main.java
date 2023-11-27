package hj.HJ13_句子逆序;
/***
描述：
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
***/
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" "); //用空格将句子分隔开并加入至数组中String[] arr
        
        StringBuilder sb = new StringBuilder();//这里使用了StringBuilder，也可以不用，直接循环倒叙打印
        for(int i = arr.length-1;i>=0;i--){
             sb.append(arr[i]+" ");
        }
        System.out.print(sb.toString());//一定要记得toString()
    }
}
