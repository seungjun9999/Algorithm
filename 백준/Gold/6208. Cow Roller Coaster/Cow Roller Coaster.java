import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int start, len, fun, cost;

        Node(int start, int len, int fun, int cost) {
            this.start = start;
            this.len = len;
            this.fun = fun;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o1) {
            if (o1.start == this.start) {
                return this.len - o1.len;
            }
            return this.start - o1.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pq.offer(new Node(q, w, e, r));
        }
        int[][] dp = new int[l + 1][b + 1];
        while (!pq.isEmpty()) {
            Node recent = pq.poll();
            for (int c = 0; c <= b; c++) {
                if (recent.cost > c) {
                    dp[recent.start + recent.len][c] = dp[recent.start][c];
                } else {
                    if (recent.start == 0 || dp[recent.start][c] != 0) {
                        dp[recent.start + recent.len][c] = Math.max(dp[recent.start + recent.len][c], dp[recent.start][c - recent.cost] + recent.fun);
                    }
                }
            }
        }
        int maax = 0;
        for (int i = 0; i <= b; i++) {
            maax = Math.max(maax, dp[l][i]);
        }
        System.out.println(maax == 0 ? -1 : maax);
    }
}