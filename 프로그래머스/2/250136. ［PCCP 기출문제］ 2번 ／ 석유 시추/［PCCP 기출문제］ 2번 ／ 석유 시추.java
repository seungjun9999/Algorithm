import java.util.*;

class Solution {
    static int[][] num;
    static int n,m,c=2;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static ArrayDeque<int[]> temp = new ArrayDeque<>();
    static ArrayList<Integer> list  = new ArrayList<>();
    public int solution(int[][] land) {
        int result = 0;
        
        n = land.length;
        m = land[0].length;
        
        num = new int[n][m];
        visited = new boolean[n][m];
        
        this.num = land;
        
        for(int i=0;i<m;i++) {
            int now = 0;
            HashSet<Integer> hs = new HashSet<>();
            for(int j=0;j<n;j++) {
                if(hs.contains(num[j][i])) continue;
                
                if(!visited[j][i] && num[j][i] != 0) {
                    dq.offer(new int[] {j,i});
                    temp.offer(new int[] {j,i});
                    visited[j][i] = true;
                    int r = bfs();
                    now+=r;
                    list.add(r);
                    hs.add(c);
                    c++;
                }else if(visited[j][i] && num[j][i]!=0) {
                    now+=list.get(num[j][i]-2);
                    hs.add(num[j][i]);
                }
            }
            result = Math.max(now,result);
        }
        
        return result;
    }
    
    static private int bfs() {
        int cnt=1;
        while(!dq.isEmpty()) {
            int[] now = dq.poll();
            for(int i=0;i<4;i++) {
                int x = dx[i] + now[0];
                int y = dy[i] + now[1];
                if(!check(x,y) || visited[x][y] || num[x][y] == 0) continue;
                visited[x][y] = true;
                dq.offer(new int[] {x,y});
                temp.offer(new int[] {x,y});
                cnt++;
            }
        }
        
        while(!temp.isEmpty()) {
            int[] now = temp.poll();
            num[now[0]][now[1]] = c;
        }
        return cnt;
    }
    
    static private boolean check(int x,int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
    
}