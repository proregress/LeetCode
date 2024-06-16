package 并查集unionFind.HJ城市聚集度;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N个节点
        int[][] arr = new int[N][2];
        for(int i = 0 ; i < N-1; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int res = Integer.MAX_VALUE;
        int[] maxArray = new int[N + 1];
        for(int i = 1; i <= N ;i++){
            UF uf = new UF(N);
            for(int j = 0; j < N-1; j++){
                if(arr[j][0] != i && arr[j][1] != i){
                    uf.union(arr[j][0], arr[j][1]);
                }
            }
            maxArray[i] = uf.getMaxSize();
            res = Math.min(res, maxArray[i]);
        }

        String result = "";
        for (int i = 1; i < maxArray.length; i++) {
            if(maxArray[i] == res){
                result = result + String.valueOf(i) + " ";
            }
        }
        System.out.println("城市聚集度= " + result);
    }

    static class UF{
        private int count; //连通分量
        private int[] parent; //节点x的父节点时parent[x]
        private int[] size;//连接个数

        public UF(int n){
            this.count = n;
            this.parent = new int[n+1]; //城市编号从1开始的
            this.size = new int[n+1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q){
            int rootP = findParent(p);
            int rootQ = findParent(q);
            if(rootP == rootQ) return;
            if(size[rootP] < size[rootQ]){
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }

        public int findParent(int x){
            if (parent[x] != x){
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }

        public boolean connected(int p, int q){
            int rootP = findParent(p);
            int rootQ = findParent(q);
            return rootP == rootQ;
        }

        public int count(){
            return count;
        }

        /* 返回最大的连接数 */
        public int getMaxSize(){
            int max = 0;
            for (int i = 1; i < size.length; i++) {
                max = Math.max(max, size[i]);
            }
            return max;
        }
    }
}
