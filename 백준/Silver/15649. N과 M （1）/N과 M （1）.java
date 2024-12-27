import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        num = new int[m];
        backt(0);
        System.out.print(sb);
    }

    static void backt(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num[cnt] = i+1;
                backt(cnt + 1);
                visited[i] = false;
            }
        }
    }
}