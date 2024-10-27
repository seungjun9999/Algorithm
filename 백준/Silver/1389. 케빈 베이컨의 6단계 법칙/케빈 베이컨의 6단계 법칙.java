import java.io.*;
import java.util.*;

public class Main {
    static int n, m, sum, result, miin = Integer.MAX_VALUE;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] bacon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 1; i < n+1; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            bacon = new int[n + 1];
            sum = 0;
            q.offer(i);
            bfs();
            for (int j = 1; j < n + 1; j++) {
                sum += bacon[j];
            }
            if (miin > sum && sum != 0) {
                miin = sum;
                result = i;
            }
        }
        System.out.println(result);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list.get(now).size(); i++) {
                int recent = list.get(now).get(i);
                if (!visited[recent]) {
                    bacon[recent] = bacon[now] + 1;
                    visited[recent] = true;
                    q.offer(recent);
                }
            }
        }
    }
}
