import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] result = new int[n][m];
        ArrayDeque<int[]>dq = new ArrayDeque<>();
        dq.offer(new int[] {0,0});
        visited[0][0] = true;
        while(!dq.isEmpty()) {
            int[] where = dq.poll();
            for(int i=0;i<4;i++) {
                int x = where[0] + dx[i];
                int y = where[1] + dy[i];
                if(!check(x,y)) continue;
                if(!visited[x][y] && maps[x][y] == 1) {
                    result[x][y] = result[where[0]][where[1]] + 1;
                    visited[x][y] = true;
                    dq.offer(new int[]{x,y});
                }
            }
        }
        return result[n-1][m-1] == 0 ? -1 : result[n-1][m-1]+1;
    }
    static boolean check(int x,int y) {
        if(x>=0 && x< n && y>= 0 && y<m) {
            return true;
        }
        return false;
    }
}