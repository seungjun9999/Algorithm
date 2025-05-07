import java.io.*;
import java.util.*;

public class Main {
    static int n, flag = 0, answer = 0;
    static ArrayList<ArrayList<Node>> list;
    static boolean[] visited;

    static class Node {
        int child, cost;

        Node(int child, int cost) {
            this.child = child;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
        visited[1] = true;
        int s = dfs(1, 0);
        answer = 0;
        visited = new boolean[n + 1];
        visited[s] = true;
        dfs(s, 0);
        System.out.println(answer);
    }

    static private int dfs(int start, int dep) {
        if (answer < dep) {
            answer = dep;
            flag = start;
        }

        for (Node now : list.get(start)) {
            if (!visited[now.child]) {
                visited[now.child] = true;
                dfs(now.child, dep + now.cost);
            }
        }
        return flag;
    }
}