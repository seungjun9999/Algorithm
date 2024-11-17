import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] num;
    static boolean[] visited; // 불린
    static StringBuilder sb;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int a, int cnt) { // 방문처리
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(list.get(i)).append(" ");

            }
            sb.append("\n");
            return;
        }
        for (int i = a; i < n; i++) {
            if (!visited[i]) {
                list.add(num[i]);
                visited[i] = true;
                dfs(a, cnt + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
