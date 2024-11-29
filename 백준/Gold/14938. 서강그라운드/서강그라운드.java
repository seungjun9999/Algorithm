import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r, maax = 0;
    static int[] item, dist;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
        int a, cost;

        Node(int a, int cost) {
            this.a = a;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o1) {
            return this.cost - o1.cost; // min 부터
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n + 1];
        dist = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        for (int i = 1; i <= n; i++) {
            maax = Math.max(maax, stra(i));
        }

        System.out.println(maax);
    }

    static int stra(int start) {
        int cnt = 0;

        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.a] < now.cost)
                continue;
            cnt += item[now.a];

            for (int i = 0; i < list.get(now.a).size(); i++) {
                Node next = list.get(now.a).get(i);
                if (dist[next.a] > dist[now.a] + next.cost && dist[now.a] + next.cost <= m) {
                    dist[next.a] = dist[now.a] + next.cost;
                    pq.offer(new Node(next.a, dist[next.a]));
                }
            }
        }
        return cnt;
    }
}