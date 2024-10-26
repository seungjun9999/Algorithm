import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] num;
    static int[][] result;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                if (num[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if (num[i][j] == 1) {
                    result[i][j] = -1;
                }
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] where = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = where[0] + dx[i];
                int y = where[1] + dy[i];
                if (check(x, y) && num[x][y] == 1) {
                    num[x][y] = 0;
                    result[x][y] = result[where[0]][where[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }

    static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }
}