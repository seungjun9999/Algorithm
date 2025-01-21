import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static int n, k;

    public int solution(int n, int[][] edges) {
        this.n = n;
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dq.offer(edges[0][0]);
        int[] check = bfs();
        dq.offer(check[1]);
        int[] result = bfs();
        if (result[0] > 1) {
            return result[2];
        } else {
            dq.offer(result[1]);
            int[] answer = bfs();
            if (answer[0] > 1) {
                return answer[2];
            } else {
                return answer[2] - 1;
            }
        }
    }

    public int[] bfs() {
        int maax = 0, cnt = 0;
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        while (!dq.isEmpty()) {
            int recent = dq.poll();
            visited[recent] = true;
            for (int a : tree.get(recent)) {
                if (!visited[a]) {
                    dq.offer(a);
                    visited[a] = true;
                    dist[a] = dist[recent] + 1;
                    if (dist[a] > maax) {
                        maax = dist[a];
                        cnt = 1;
                        k = a;
                    } else if (dist[a] == maax) {
                        cnt += 1;
                    }
                }
            }
        }
        return new int[]{cnt, k, maax};
    }
}