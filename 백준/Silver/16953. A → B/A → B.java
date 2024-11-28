import java.io.*;
import java.util.*;

public class Main {
    static long a, b, result;
    static ArrayDeque<Node> adq = new ArrayDeque<>();

    static class Node {
        long x, cnt;

        Node(long x, long cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        adq.offer(new Node(a, 1));
        bfs();
        System.out.println(result);
    }

    static void bfs() {
        while (!adq.isEmpty()) {
            Node now = adq.poll();
            if (now.x==b) {
                result = now.cnt;
                return;
            }
            long q = now.x * 2;
            long w = now.x * 10 + 1;
            if (q <= b) {
                adq.offer(new Node(q, now.cnt + 1));
            }
            if (w <= b) {
                adq.offer(new Node(w, now.cnt + 1));
            }
        }
        result=-1;
    }
}
