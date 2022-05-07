/*** 
定理：一个正整数最多有一个质因子大于其平方根，且只会是其本身
所以判断一个数num是否是质数时，没必要从 2 一直尝试到 num，写到num的平方根即可，如果此时数字还没有除数，则可判定其本身是一个质数，没有再除下去的必要了，直接打印其本身即可
***/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { 
            int n = in.nextInt();
            
            int minLen = n;
            
            HashMap<Integer,Integer> map = new HashMap<>();
            
            //1.暴力枚举，寻找n的所有素数对（i，n-i），将（i，length）放进map中
            for(int i = 0; i <= n/2; i++){
                if(isPrime(i) && isPrime(n-i)){
                    map.put(i, n-i-i);
                }
            }
            
            //遍历map，找到length最短的值
            for(int i : map.keySet()){
                minLen = Math.min(minLen, map.get(i)); //find the minium length
            }
            
            // find the i:n-i from the map base on the minLen
            for(int i : map.keySet()){
                if(map.get(i) == minLen){
                    System.out.println(i);
                    System.out.println(n-i);
                }
            }           
        }
    }
    
    //is n a prime? if n is a prime, then n can only be divided by 1 or n itself;
    public static boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
