package 并查集unionFind.L0323_无向图中的连通分量数目;

/**
 * 题目：
 * 给你输入一个包含n个节点的图，用一个整数n和一个数组edges表示，其中edges[i]=[ai,bi]表示图中节点ai和bi之间有一条边。
 * 请你计算这幅图中的连通分量个数
 */
public class Solution {
    public int countComponents(int n , int[][] edges){
        UF uf = new UF(n);

        //将每个节点进行连通
        for(int[] e : edges){
            uf.union(e[0], e[1]);
        }

        //返回连通分量的个数
        return uf.count();

    }

    /**
     * 定义并查集
     */
    class UF{
        //连通分量个数
        private int count;
        //存储每个节点的父节点
        private int[] parent;

        //n为图中节点的个数
        public UF(int n){
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        //将节点p和节点q连通
        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            if(rootP == rootQ){
                return;
            }
            parent[rootQ] = rootP;
            // 两个连通分量合并成一个连通分量
            count--;
        }

        //判断节点p和节点q是否连通
        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        //寻找节点x的根节点
        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]); //路径压缩
            }
            return parent[x];
        }

        //返回图中的连通分量个数
        public int count(){
            return count;
        }
    }
}
