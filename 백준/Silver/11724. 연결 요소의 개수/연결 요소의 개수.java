import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cnt = 0;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                q.offer(i);
                bfs();
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list.get(now).size(); i++) {
                int idx = list.get(now).get(i);
                if (!visited[idx]) {
                    q.offer(idx);
                    visited[idx] = true;
                }
            }
        }
    }
}
