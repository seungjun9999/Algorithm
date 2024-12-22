import java.io.*;
import java.util.*;

public class Main {
    static int n, hmax = 0, hmin = 101, cnt, result = 0;
    static int[][] num;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static ArrayDeque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                hmax = Math.max(hmax, num[i][j]);
                hmin = Math.min(hmin, num[i][j]);
            }
        }
        for (int i = hmin - 1; i <= hmax; i++) { // 아무지역도 안잠길 수 있음
            visited = new boolean[n][n];
            cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (num[j][k] > i && !visited[j][k]) {
                        cnt++;
                        visited[j][k] = true;
                        dq.offer(new int[] { j, k });
                        bfs(i);
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }

    static void bfs(int h) {
        while (!dq.isEmpty()) {
            int[] where = dq.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + where[0];
                int y = dy[i] + where[1];
                if (check(x, y) && num[x][y] > h && !visited[x][y]) {
                    visited[x][y] = true;
                    dq.offer(new int[] { x, y });
                }
            }
        }
    }

    static boolean check(int a, int b) {
        if (a >= 0 && a < n && b >= 0 && b < n) {
            return true;
        }
        return false;
    }
}