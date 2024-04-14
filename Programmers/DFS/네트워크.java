package Programmers.DFS;

class 네트워크 {
    static boolean[][] visited;
    static int cnt = 0;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && computers[i][j] == 1) {
                    dfs(computers, n, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int[][] computers, int n, int a) {
        for (int j = 0; j < n; j++) {
            if (!visited[a][j] && computers[a][j] != 0) {
                visited[a][j] = true;
                visited[j][a] = true;
                dfs(computers, n, j);
            }
        }

    }
}
