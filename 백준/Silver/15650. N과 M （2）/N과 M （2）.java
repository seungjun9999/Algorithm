import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dfs(1, 0);
        System.out.println(sb);
    }

    static void dfs(int a, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = a; i <= n; i++) {
            list.add(i);
            dfs(i + 1, cnt + 1);
            list.remove(list.size() - 1);
        }
    }
}
