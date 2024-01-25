### **bfs广度优先搜索纲领**：


###1. 本质问题: 在一幅「图」中找到从起点start到终点target的最近距离
####变体：走迷宫，迷宫带传送门，两个单词替换最少字母使其相同，连连看两个方块之间最短连线不能多于两个拐点。。。

###2. bfs代码框架

    // 计算从起点 start 到终点 target 的最近距离
    int BFS(Node start, Node target) {
        Queue<Node> queue; // 核心数据结构
        Set<Node> visited; // 避免走回头路
    
        queue.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数
    
        while (queue.notEmpty()) {
            int size = queue.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur == target)
                    return step;
                /* 将 cur 的相邻节点加入队列 */
                for (Node x : cur.allAdjacent())
                    if (x not in visited) {
                        q.offer(x);
                        visited.add(x);
                    }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
    }


