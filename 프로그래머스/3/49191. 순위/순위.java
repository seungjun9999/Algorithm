import java.util.*;

class Solution {
    static int n;
    public int solution(int n, int[][] results) {
        int answer = 0;
        this.n = n;
        ArrayList<ArrayList<Integer>> lose = new ArrayList<>();
        ArrayList<ArrayList<Integer>> win = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lose.add(new ArrayList<>());
            win.add(new ArrayList<>());
        }
        for (int[] result : results) {
            win.get(result[0]).add(result[1]);
            lose.get(result[1]).add(result[0]);
        }
        for (int i = 1; i <= n; i++) {
            bfs(win, i);
            bfs(lose, i);
        }
        for (int i = 1; i <= n; i++) {
            if (win.get(i).size() + lose.get(i).size() == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    void bfs(ArrayList<ArrayList<Integer>> list, int idx) {
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            temp.add(new ArrayList<>(list.get(i)));
        }
        for (int a : list.get(idx)) {
            visited[a] = true;
            dq.offer(a);
        }
        while (!dq.isEmpty()) {
            int now = dq.poll();
            for (int a : temp.get(now)) {
                if (!visited[a]) {
                    dq.offer(a);
                    visited[a] = true;
                    list.get(idx).add(a);
                }
            }
        }
    }
}