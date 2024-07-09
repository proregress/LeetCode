package 逻辑分析.HJ342_最富裕的小家庭;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[N+1];
        int[] wealth = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.valueOf(s[i-1]);
        }
        for (int i = 0; i < N - 1; i++) {
            String[] s1 = sc.nextLine().split(" ");
            int N1 = Integer.valueOf(s1[0]);
            int N2 = Integer.valueOf(s1[1]);
            if(wealth[N1] != 0 ){
                wealth[N1] += nums[N2];
            }else {
                wealth[N1] = nums[N1] + nums[N2];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, wealth[i]);
        }
        System.out.println(ans);
    }
}
