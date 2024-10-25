import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h, max = 0, cnt = 0;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] tmt;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tmt = new int[h][n][m];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    tmt[k][i][j] = Integer.parseInt(st.nextToken());
                    if (tmt[k][i][j] == 1) {
                        q.offer(new int[]{k, i, j});
                    } else if (tmt[k][i][j] == 0) {
                        cnt++;
                    }
                }
            }
        }
        if (cnt == 0) {
            System.out.println(0);
        } else {
            int result = bfs();
            System.out.println(cnt == 0 ? result : -1);
        }
    }

    static int bfs() {
        while (!q.isEmpty()) {
            int[] where = q.poll();
            for (int i = 0; i < 6; i++) {
                int z = where[0] + dz[i];
                int x = where[1] + dx[i];
                int y = where[2] + dy[i];
                if (check(z, x, y) && tmt[z][x][y] == 0) {
                    tmt[z][x][y] = tmt[where[0]][where[1]][where[2]] + 1;
                    cnt--;
                    if (max < tmt[z][x][y]) {
                        max = tmt[z][x][y];
                    }
                    q.offer(new int[]{z, x, y});
                }
            }
        }
        return max - 1;
    }

    static boolean check(int z, int x, int y) {
        if (z >= 0 && z < h && x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }
}