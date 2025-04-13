import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] ju, bum;
    static char[][] map;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static boolean grap = false;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        ju = new int[]{x1 - 1, y1 - 1};
        bum = new int[]{x2 - 1, y2 - 1};

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int cnt = 0;
        while (!grap) {
            cnt += bfs();
        }
        System.out.println(cnt);
    }

    static private int bfs() {
        dq.offer(ju);
        visited = new boolean[n][m];
        visited[ju[0]][ju[1]] = true;
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + now[0];
                int y = dy[i] + now[1];
                if (!check(x, y) || visited[x][y]) continue;
                if (map[x][y] == '1') {
                    map[x][y] = '0';
                } else if (map[x][y] == '0') {
                    dq.offer(new int[]{x, y});
                } else {
                    grap = true;
                }
                visited[x][y] = true;
            }
        }

        return 1;
    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}