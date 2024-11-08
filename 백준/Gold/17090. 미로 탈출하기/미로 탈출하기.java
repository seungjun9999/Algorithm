import java.io.*;
import java.util.*;

public class Main {
    static int n, m, result = 0;
    static char[][] miro;
    static boolean[][] visited;
    static boolean suc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = arr.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                suc = false;
                if (run(i, j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static boolean run(int a, int b) {
        if (a == -1 || b == -1 || a == n || b == m) {
            return true;
        }

        if (miro[a][b] == 'T') {
            return true;
        } else if (miro[a][b] == 'F') {
            return false;
        }

        if (visited[a][b]) {
            return false;
        }

        visited[a][b] = true;
        if (miro[a][b] == 'D') {
            suc = run(a + 1, b);
        } else if (miro[a][b] == 'U') {
            suc = run(a - 1, b);
        } else if (miro[a][b] == 'R') {
            suc = run(a, b + 1);
        } else {
            suc = run(a, b - 1);
        }

        if (suc) {
            miro[a][b] = 'T';
        } else {
            miro[a][b] = 'F';
        }
        return suc;
    }
}
