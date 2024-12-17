import java.io.*;
import java.util.*;

public class Main {
    static int n, m, start, end;
    static int[] dist, city;
    static boolean[] visited;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static ArrayList<Integer> route = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int to, w;

        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        city = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weigth = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, weigth));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        stra();
        sb.append(dist[end]).append("\n");
        while (end != 0) {
            route.add(end);
            end = city[end];
        }
        sb.append(route.size()).append("\n");
        for (int i = route.size() - 1; i >= 0; i--) {
            sb.append(route.get(i)).append(" ");
        }
        System.out.print(sb);
    }

    static void stra() {
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        city[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.to]) {
                visited[now.to] = true;
            } else {
                continue;
            }
            for (Node next : list.get(now.to)) {
                if (dist[next.to] > dist[now.to] + next.w) {
                    dist[next.to] = dist[now.to] + next.w;
                    pq.offer(new Node(next.to, dist[next.to]));
                    city[next.to] = now.to;
                }
            }
        }
    }
}