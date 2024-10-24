import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cnt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] miro;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        miro = new char[n][m];
        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = arr.charAt(j);
                if (miro[i][j] == 'I') {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        System.out.println(bfs() == 0 ? "TT" : bfs());
    }

    static int bfs() {
        while (!q.isEmpty()) {
            int[] where = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + where[0];
                int y = dy[i] + where[1];
                if (check(x, y) && miro[x][y] != 'X' && !visited[x][y]) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                    if (miro[x][y] == 'P') {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }
}
