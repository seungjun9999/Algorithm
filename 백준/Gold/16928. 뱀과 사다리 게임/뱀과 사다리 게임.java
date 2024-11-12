import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] num = new int[100];
    static boolean[] visited = new boolean[100];

    static class Node {
        int x, cnt;

        Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    static Queue<Node> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            num[a] = b;
        }
        q.offer(new Node(1, 0));
        visited[1] = true;
        System.out.println(bfs());
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 1; i <= 6; i++) {
                int go = now.x + i;
                if(go == 100){
                    return now.cnt+1;
                }
                if (go <= 100 && !visited[go]){
                    if (num[go]==0){
                        q.offer(new Node(go, now.cnt+1));
                    }else{
                        q.offer(new Node(num[go], now.cnt+1));
                        visited[num[go]] = true;
                    }
                    visited[go] = true;
                }
            }
        }
        return 0;
    }
}
