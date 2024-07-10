package 数据结构.数组.差分数组.L1109_航班预定统计;

public class Solution {
    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int[] ints = corpFlightBookings(bookings, 5);
        System.out.println("ints = " + ints);
    }
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        // 先构造差分数组，本题差分数组起始均为0
        //diff[i]定义：diff[i] = nums[i] - nums[i-1]
        int[] diff = new int[n];

        //返回值
        int[] answer = new int[n];

        for (int[] row : bookings){
            // [[i,j]之间的值要加上num
            int i = row[0] - 1;
            int j = row[1] - 1;
            int num = row[2];

            // 使用差分数组技巧处理：对[i，...]的数字加num， 再对[j，...]的数字减10
            diffence(diff, i , j , num);
        }

        // 全部处理完毕后，通过diff[]重新构造数组
        answer[0] = diff[0];
        for(int i = 1 ; i < n ; i++){
            answer[i] = answer[i-1] + diff[i];
        }

        return answer;
    }

    static void diffence(int[] diff, int i , int j , int num){
        diff[i] = diff[i] + num;
        if(j + 1 < diff.length){
            diff[j+1] = diff[j+1] - num;
        }
    }
}
