import java.io.*;
import java.util.*;

public class Main {
    static int n, m, w;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node> list;

    static class Node {
        int s, t, e;

        Node(int s, int e, int t) {
            this.s = s;
            this.e = e;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        c:
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new Node(a, b, c));
                list.add(new Node(b, a, c));
            }
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new Node(a, b, -c));
            }

            if (!bellmanFord(1)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

        }
        System.out.print(sb);
    }

    static private boolean bellmanFord(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m * 2 + w; j++) {
                Node now = list.get(j);
                if (dist[now.e] > dist[now.s] + now.t) {
                    dist[now.e] = dist[now.s] + now.t;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m * 2 + w; j++) {
                Node now = list.get(j);
                if (dist[now.e] > dist[now.s] + now.t) {
                    return false;
                }
            }
        }
        return true;
    }
}