import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static int n,newCost;
    static int[][][] cost;
    public int solution(int[][] board) {
        n = board.length;
        cost = new int[n][n][4];
        dq.offer(new int[] {0,0,0});
        dq.offer(new int[] {0,0,1});
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 && j==0) continue;
                Arrays.fill(cost[i][j],Integer.MAX_VALUE);
            }
        }
        while(!dq.isEmpty()) {
            int[] now = dq.poll();
            for(int i=0;i<4;i++) {
                int x = dx[i] + now[0];
                int y = dy[i] + now[1];
                if(!check(x,y) || board[x][y] == 1) continue;
                newCost = cost[now[0]][now[1]][now[2]];
                if(i == now[2]) {
                    newCost += 100;
                }else {
                    newCost += 600;
                }
                if(cost[x][y][i] > newCost) {
                    cost[x][y][i] = newCost;
                    dq.offer(new int[]{x,y,i});
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i=0;i<4;i++) {
            result = Math.min(result,cost[n-1][n-1][i]);
        }
        return result;
    }
    public boolean check(int x,int y) {
        if(x>=0 && x<n && y>=0 && y<n) {
            return true;
        }
        return false;
    }
}