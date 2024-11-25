import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] num;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        backt(0);
        System.out.print(sb);
    }

    static void backt(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && num[i] != t) {
                visited[i] = true;
                list.add(num[i]);
                t = num[i];
                backt(cnt + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}