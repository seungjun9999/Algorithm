import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static boolean[] visited;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        num = new int[n + 1];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        q.offer(1);
        visited[1] = true;
        bfs();
        for (int i = 2; i <= n; i++) {
            sb.append(num[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i = 0; i < list.get(t).size(); i++) {
                int now = list.get(t).get(i);
                if (!visited[now]) {
                    num[now] = t;
                    visited[now] = true;
                    q.offer(now);
                }
            }
        }
    }
}