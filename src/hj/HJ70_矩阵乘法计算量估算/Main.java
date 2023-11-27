package hj.HJ70_矩阵乘法计算量估算;

// 50 10 得到50行5列举证，乘法次数为 50 * 5 * 10 = 2500
// 10 5
    
// 10 20
// 20 5
//     得到10行5列的矩阵，乘法次数为 10 * 5 * 20 = 1000
    
//     1 2 4 5    6 7 8   得到2行3列的矩阵，乘法次数为：2 * 3 * 公共行列数
//     1 4 5 8    2 5 0
//                5 2 6
//                1 5 8   
//规律：(m,d) *(d ,n) 得到 （m，n）的矩阵，乘法次数为：m * n * d


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { 
            int sum = 0;
            int n = in.nextInt();
            int[][] a = new int[n][2];
            for(int i = 0; i < n; i++){
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
            }
            String str = in.next();
            char[] chs = str.toCharArray();
            
            Stack<Integer> stack = new Stack<>();
            for(int i = chs.length-1, j=n-1; i>=0; i--){
                if(chs[i] >= 'A' && chs[i] <= 'Z'){
                    stack.push(a[j][1]);
                    stack.push(a[j][0]);
                    j--;
                }
                if(chs[i] == '('){
                    int x0 = stack.pop();
                    int y0 = stack.pop();
                    int x1 = stack.pop();
                    int y1 = stack.pop();
                    sum = sum + x0 * y1 * y0;
                    stack.push(y1);
                    stack.push(x0);
                }    
            }
            System.out.println(sum);
        }
    }
}



