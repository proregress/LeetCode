package hj.HJ43_迷宫问题;

import java.util.*;

public class Main {
    public static ArrayList<int[]> path = new ArrayList<>();//搜索所有可能的路径
    public static ArrayList<int[]> best_path = new ArrayList<>();//最短路径
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { 
//             path.clear();
//             best_path.clear();//每个用例之前，都要清空下路径
            
            int x = in.nextInt();
            int y = in.nextInt();
            int[][] maze = new int[x][y];
            for(int i = 0; i<x; i++){
                for(int j = 0; j<y; j++){
                    maze[i][j] = in.nextInt();
                }
            }
            
            dfs(0,0,maze);//深度搜索+回溯
            for(int[] pathi : best_path){
                System.out.println("("+pathi[0]+","+pathi[1]+")");
            }
        }
    }
    
    public static void dfs(int x, int y, int[][] maze){
        //越界，return
        if(x < 0 || y < 0 || x > maze.length-1 || y > maze[0].length-1){
            return;
        }
        //碰壁，return
        if(maze[x][y] == 1){
            return;
        }
        //终止条件：找到终点了
        if( x == maze.length-1 && y == maze[0].length-1){
            path.add(new int[]{maze.length-1, maze[0].length-1}); //将终点坐标放入path中
            if(best_path.size() == 0 || path.size() < best_path.size()){ //比较是否遇到更短路径
                best_path.clear(); //清空之前的最短路径，将新的最短存放进去
                for(int[] path0 : path){
                    best_path.add(path0);
                }
            }
            return;
        }
        maze[x][y] = 1;  //标记走过的点
        path.add(new int[]{x,y}); //将其添加进路径中
        dfs(x+1,y,maze); //下
        dfs(x,y+1,maze); //右
        dfs(x-1,y,maze); //上
        dfs(x,y-1,maze); //左
        path.remove(path.size()-1); //回溯，移除最后一个点
        maze[x][y] = 0; //回溯，恢复到之前的状态
    }
    
}
