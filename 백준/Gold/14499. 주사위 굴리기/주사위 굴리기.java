import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] num;
    static int[] dice = new int[6]; // 0 위, 1 아래, 2 오른쪽, 3 왼쪽, 4 앞쪽, 5 뒷쪽
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (!check(x + dx[v], y + dy[v])) continue;
            x += dx[v];
            y += dy[v];
            int temp = dice[0];
            if (v == 4) {
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
            } else if (v == 3) {
                dice[0] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
            } else if (v == 2) {
                dice[0] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
            } else {
                dice[0] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
            }

            if (num[x][y] == 0) {
                num[x][y] = dice[1];
            } else {
                dice[1] = num[x][y];
                num[x][y] = 0;
            }

            sb.append(dice[0]).append("\n");
        }
        System.out.print(sb);
    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}