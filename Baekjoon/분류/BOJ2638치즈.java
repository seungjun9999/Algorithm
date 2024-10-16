import java.io.*;
import java.util.*;

public class BOJ2638치즈 {
    static int n, m, cnt1 = 0, result;
    static int[][] num;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static Queue<int[]> queue, remove, chz = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                if (num[i][j] == 1) {
                    cnt1++;
                    chz.offer(new int[] { i, j });
                }
            }
        }
        while (cnt1 != 0) {
            air();
            melt();
            last();
            result++;
        }
        System.out.println(result);
    }

    static void air() {
        visited = new boolean[n][m];
        queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        while (!queue.isEmpty()) {
            int[] where = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + where[0];
                int y = dy[i] + where[1];
                if (check(x, y) && num[x][y] == 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[] { x, y });
                }
            }
        }
    }

    static void melt() {
        remove = new LinkedList<>();
        int len = chz.size();
        for (int i = 0; i < len; i++) {
            int[] where = chz.poll();
            int cnt = 0;
            int x, y;
            for (int j = 0; j < 4; j++) {
                x = dx[j] + where[0];
                y = dy[j] + where[1];
                if (check(x, y) && num[x][y] == 0 && visited[x][y]) {
                    cnt++;
                }
            }
            if (cnt > 1) {
                remove.offer(new int[] { where[0], where[1] });
            } else {
                chz.offer(new int[] { where[0], where[1] });
            }
        }
    }

    static void last() {
        while (!remove.isEmpty()) {
            int[] where = remove.poll();
            num[where[0]][where[1]] = 0;
            cnt1--;
        }
    }

    static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }
}
