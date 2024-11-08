import java.util.*;
import java.io.*;

public class Main {
    static int n, m, sum, result = Integer.MAX_VALUE;
    static int[][] num;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> ck = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                if (num[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if (num[i][j] == 2) {
                    ck.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[ck.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int i, int cnt) {
        if (cnt == m) {
            sum = 0;
            for (int j = 0; j < home.size(); j++) {
                int miin = Integer.MAX_VALUE;
                for (int k = 0; k < ck.size(); k++) {
                    if (visited[k]) {
                        miin = Math.min(miin, Math.abs(ck.get(k)[0] - home.get(j)[0]) + Math.abs(Math.abs(ck.get(k)[1] - Math.abs(home.get(j)[1]))));
                    }
                }
                sum += miin;
            }
            result = Math.min(sum, result);
            return;
        }
        for (int a = i; a < ck.size(); a++) {
            visited[a] = true;
            dfs(a + 1, cnt + 1);
            visited[a] = false;
        }
    }
}
