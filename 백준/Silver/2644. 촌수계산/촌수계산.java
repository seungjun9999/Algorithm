import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{x, 0});
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            for (int a : list.get(now[0])) {
                if(a==y) {
                    System.out.println(now[1]+1);
                    return;
                }
                if (!visited[a]) {
                    visited[a] = true;
                    dq.offer(new int[]{a, now[1] + 1});
                }
            }
        }
        System.out.println(-1);
    }
}