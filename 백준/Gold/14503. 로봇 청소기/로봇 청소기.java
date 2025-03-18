import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] num;
    static boolean quit = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r, c, d);
        System.out.println(answer);
    }

    static private void dfs(int r, int c, int d) {
        if (quit) return;

        if (num[r][c] == 0) {
            num[r][c] = -1;
            answer++;
        }
        int flag = 0;
        for (int i = 0; i < 4; i++) {
            d -= 1;
            if (d < 0) d += 4;
            int x = r + dx[d];
            int y = c + dy[d];
            if (num[x][y] == 0) {
                dfs(x, y, d);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            int e = (d + 2) % 4;
            int x = r + dx[e];
            int y = c + dy[e];
            if (num[x][y] == 1) {
                quit = true;
            } else {
                dfs(x, y, d);
            }
        }

    }

}