import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int go, cost;

        Node(int go, int cost) {
            this.go = go;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o1) {
            return this.cost - o1.cost;
        }
    }

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int N;
    static int[][] road;
    static int[] dist;
    static boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        this.N = N;
        this.road = road;
        // 도로 초기화
        initRoad();
        // 거리 초기화
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        pq.offer(new Node(1, 0));
        visited = new boolean[N + 1];
        stra();

        int answer = 0;
        for (int a : dist) {
            if (a <= K) answer++;
        }
        return answer;
    }

    public void stra() {
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.go]) continue;
            visited[now.go] = true;
            for (Node next : list.get(now.go)) {
                if (dist[next.go] > next.cost + dist[now.go]) {
                    dist[next.go] = next.cost + dist[now.go];
                    pq.offer(new Node(next.go, dist[next.go]));
                }
            }
        }
    }

    public void initRoad() {
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] rod : road) {
            list.get(rod[0]).add(new Node(rod[1], rod[2]));
            list.get(rod[1]).add(new Node(rod[0], rod[2]));
        }
    }
}