package 并查集unionFind.城市聚集度;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N个节点
        UF uf = new UF(N);
        for(int i = 0 ; i < N-1; i++){
            int x = sc.nextInt(); //城市x
            int y = sc.nextInt(); //城市y
            uf.union(x, y);
        }
        int ans = uf.count();
        System.out.println("城市聚集度= " + ans);
    }

    static class UF{
        private int count;
        private int[] parent;

        public UF(int n){
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q){
            int rootP = findParent(p);
            int rootQ = findParent(q);
            if(rootP == rootQ) return;
            parent[rootQ] = rootP;
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
    }
}
