import java.io.*;
import java.util.*;

public class Main {
    static int r, c, t, airup = 0, airdw = 0, result = 0;
    static int[][] num, map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        num = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                if (num[i][j] == -1 && airup == 0) {
                    airup = i;
                    airdw = i + 1;
                }
            }
        }
        while (t-- > 0) {
            dust();
            num = map;
            clean();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (num[i][j] > 0) {
                    result += num[i][j];
                }
            }
        }
        System.out.println(result);
    }

    static void dust() {
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (num[i][j] == -1) {
                    map[i][j] = -1;
                }
                if (num[i][j] > 0) {
                    map[i][j] += num[i][j];
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || x >= r || y < 0 || y >= c) {
                            continue;
                        }
                        if (num[x][y] == -1) {
                            continue;
                        }
                        map[x][y] += num[i][j] / 5;
                        map[i][j] -= num[i][j] / 5;
                    }
                }
            }
        }
    }

    static void clean() {
        num[airup - 1][0] = 0;
        for (int i = airup - 2; i >= 0; i--) {
            num[i + 1][0] = num[i][0];
        }
        for (int i = 1; i < c; i++) {
            num[0][i - 1] = num[0][i];
        }
        for (int i = 1; i <= airup; i++) {
            num[i - 1][c - 1] = num[i][c - 1];
        }
        for (int i = c - 2; i > 0; i--) {
            num[airup][i + 1] = num[airup][i];
        }
        num[airup][1] = 0;
        num[airdw + 1][0] = 0;
        for (int i = airdw + 2; i < r; i++) {
            num[i - 1][0] = num[i][0];
        }
        for (int i = 1; i < c; i++) {
            num[r - 1][i - 1] = num[r - 1][i];
        }
        for (int i = r - 2; i >= airdw; i--) {
            num[i + 1][c - 1] = num[i][c - 1];
        }
        for (int i = c - 2; i > 0; i--) {
            num[airdw][i + 1] = num[airdw][i];
        }
        num[airdw][1] = 0;
    }
}