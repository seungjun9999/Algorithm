import java.io.*;
import java.util.*;

public class Main {
    static int n, m, result = 0;
    static int[][] num;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1,num[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(result);
    }

    static void dfs(int x, int y, int cnt,int sum) {
        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (check(a, b) && !visited[a][b]) {
                if (cnt == 2) {
                    visited[a][b] = true;
                    dfs(x, y, cnt + 1,sum+num[a][b]);
                    visited[a][b] = false;
                }
                visited[a][b] = true;
                dfs(a, b, cnt + 1,sum+num[a][b]);
                visited[a][b] = false;
            }
        }

    }

    static boolean check(int a, int b) {
        if (a >= 0 && a < n && b >= 0 && b < m) {
            return true;
        }
        return false;
    }
}
