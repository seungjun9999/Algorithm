import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }
        for (int[] wire : wires) {
            int q = wire[0];
            int w = wire[1];
            int cnt = 1;
            boolean[] visited = new boolean[n + 1];
            visited[1] = true;
            ArrayDeque<Integer> dq = new ArrayDeque<>();

            dq.offer(1);

            while (!dq.isEmpty()) {
                int c = dq.poll();
                for (int a : list.get(c)) {
                    if (visited[a] || (c == q && a == w || c == w && a == q)) continue;
                    visited[a] = true;
                    dq.offer(a);
                    cnt++;
                }
            }
            answer = Math.min(answer, Math.abs(n - cnt * 2));
        }

        return answer;
    }
}