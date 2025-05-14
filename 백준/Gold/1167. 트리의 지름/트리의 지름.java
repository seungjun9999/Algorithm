import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) {
                    break;
                }
                int c = Integer.parseInt(st.nextToken());
                list.get(a).add(new int[]{b, c});
            }
        }
        int[] result = bfs(1);
        result = bfs(result[0]);
        
        System.out.print(result[1]);
    }

    static private int[] bfs(int start) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        dq.offer(new int[]{start, 0});
        int maax = 0, lng = start;
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            if (maax < now[1]) {
                maax = now[1];
                lng = now[0];
            }
            for (int[] v : list.get(now[0])) {
                if (!visited[v[0]]) {
                    visited[v[0]] = true;
                    dq.offer(new int[]{v[0], now[1] + v[1]});
                }
            }
        }
        return new int[]{lng, maax};
    }
}