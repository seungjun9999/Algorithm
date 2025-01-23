import java.util.*;

class Solution {
    static char[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int[][] num;
    static int n,m,result=0;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        map = new char[n][m];
        num = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    dq.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        while(!dq.isEmpty()) {
            int[] where = dq.poll();
            for(int i=0;i<4;i++) {
                int x = where[0]+dx[i];
                int y = where[1]+dy[i];
                if(!check(x,y) || visited[x][y] || map[x][y] == 'X') continue;        
                num[x][y] = num[where[0]][where[1]] + 1;
                System.out.println(""+x+"와"+y+"는" + num[x][y]);
                if(map[x][y] == 'L') {
                    result += num[x][y];
                    System.out.println("중간"+result);
                    num = new int[n][m];
                    visited = new boolean[n][m];
                    dq = new ArrayDeque<>();
                    visited[x][y] = true;
                    dq.offer(new int[] {x,y});
                    break;
                }
                if(map[x][y] == 'E' && result!=0) {
                    result += num[x][y];
                    System.out.print(result);
                    return result;
                }
                visited[x][y] = true;
                dq.offer(new int[] {x,y});
            }
        }
        return -1;     
    }
    static boolean check(int x,int y) {
        if(x>=0 && x< n && y>=0 && y<m) {
            return true;
        }
        return false;
    }
}