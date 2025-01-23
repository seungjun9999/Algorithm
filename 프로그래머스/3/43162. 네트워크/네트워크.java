class Solution {
    static boolean[] visited;
    static int[][] computers;
    static int n;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        this.computers = computers;
        this.n = n;
        int cnt=0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) { 
                visited[i] = true;
                cnt++;
                dfs(i);
            }
        }
        return cnt;
    }
    static void dfs(int a) {
        for(int i=0;i<n;i++) {
           if(!visited[i] && computers[a][i] == 1) {
               visited[i] = true;
               dfs(i);
           }
        }
    }
}