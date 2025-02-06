class Solution {
    static int[][] board;
    static int n,m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    
    private boolean check(int x,int y) {
        if(x>=0 && x<n && y>=0&& y< m) return true;
        return false;
    }
    
    private int backt(int[] cur, int[] next) {
        
        if(visited[cur[0]][cur[1]]) {
            return 0;
        }
        
        int ret = 0;
        
        for(int i=0;i<4;i++) {
            int x = cur[0] + dx[i];
            int y = cur[1] + dy[i];
            if(!check(x,y) || visited[x][y] || board[x][y] == 0) continue;
            visited[cur[0]][cur[1]] = true;
            int val = backt(next, new int[]{x,y}) + 1;
            visited[cur[0]][cur[1]] = false;
            
            if(ret % 2 == 0 && val % 2 == 1) ret = val;
            else if(ret % 2 == 0 && val % 2 == 0) ret = Math.max(ret,val);
            else if(ret % 2 == 1 && val % 2 == 1) ret = Math.min(ret,val);
        }
        
        return ret;
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board  = board;
        
        n = board.length;
        m = board[0].length;
        
        visited = new boolean[n][m];
        
        return backt(aloc,bloc);
    }
    
}