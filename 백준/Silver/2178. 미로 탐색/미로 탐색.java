import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] num;
    static boolean[][] visited;
    static int n, m;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            num[i] = arr.toCharArray();
        }

        dq.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            int[] where = dq.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + where[0];
                int y = dy[i] + where[1];
                if (x == n - 1 && y == m - 1) {
                    System.out.println(where[2] + 1);
                    return;
                }
                if (!check(x, y) || visited[x][y] || num[x][y] == '0') {
                    continue;
                }
                dq.offer(new int[]{x, y, where[2] + 1});
                visited[x][y] = true;
            }
        }

    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
