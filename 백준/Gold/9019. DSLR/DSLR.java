import java.io.*;
import java.util.*;

public class Main {
    static int a, b;
    static Queue<Node> q;
    static boolean[] visited;
    static String[] plus = {"D", "S", "L", "R"};

    static class Node {
        int n;
        String arr;

        Node(int n, String arr) {
            this.n = n;
            this.arr = arr;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            visited = new boolean[10000];
            q.offer(new Node(a, ""));
            System.out.println(bfs());
        }
    }

    static String bfs() {
        while (!q.isEmpty()) {
            Node where = q.poll();
            for (int i = 0; i < 4; i++) {
                int recent = ds(where.n, i);
                if (!visited[recent]) {
                    if (recent == b) {
                        return where.arr + plus[i];
                    }
                    q.offer(new Node(recent, where.arr + plus[i]));
                    visited[recent] = true;
                }
            }
        }
        return "";
    }

    static int ds(int w, int i) {
        int result = 0;
        if (i == 0) {
            result = w * 2 % 10000;
        } else if (i == 1) {
            result = w;
            if (result == 0) {
                result = 9999;
            } else {
                result -= 1;
            }
        } else if (i == 2) {
            result = (w % 1000) * 10 + w / 1000;
        } else {
            result = (w % 10) * 1000 + w / 10;
        }
        return result;
    }
}
