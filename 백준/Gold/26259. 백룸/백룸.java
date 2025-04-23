import java.io.*;
import java.util.*;

public class Main {
    static int[][] num, dp;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int[] q = new int[4];
    static int n, m, flag;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = num[0][0];
        dq.offer(new int[]{0, 0});
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            q[i] = Integer.parseInt(st.nextToken());
        }
        if (q[0] == q[2] && q[1] > q[3]) {
            int temp = q[3];
            q[3] = q[1];
            q[1] = temp;
        } else if (q[1] == q[3] && q[0] > q[2]) {
            int temp = q[2];
            q[2] = q[0];
            q[0] = temp;
        }

        if (q[0] == q[2] && q[1] == q[3]) flag = 0;
        else if (q[0] == q[2]) flag = 1;
        else flag = 2;

        bfs();
        if (dp[n - 1][m - 1] == Integer.MIN_VALUE) System.out.print("Entity");
        else System.out.print(dp[n - 1][m - 1]);
    }

    static private void bfs() {
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            for (int i = 0; i < 2; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (!check(x, y)) continue;
                if (flag == 1) {
                    if (x == q[0] && now[0] == q[0] - 1 && now[1] >= q[1] && now[1] < q[3]) {
                        continue;
                    }
                }
                if (flag == 2) {
                    if (y == q[1] && now[1] == q[1] - 1 && now[0] >= q[0] && now[0] < q[2]) {
                        continue;
                    }
                }
                if (num[x][y] + dp[now[0]][now[1]] > dp[x][y]) {
                    dp[x][y] = num[x][y] + dp[now[0]][now[1]];
                    dq.offer(new int[]{x, y});
                }
            }
        }
    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}