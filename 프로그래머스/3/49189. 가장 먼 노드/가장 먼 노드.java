import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] visited = new int[n+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
        }
        for(int[] e : edge) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        visited[1] = 1;
        dq.offer(1);
        while(!dq.isEmpty()) {
            int now = dq.poll();
            for(int a : list.get(now)) {
                if(visited[a] == 0) {
                    dq.offer(a);
                    visited[a] = visited[now] + 1;
                    if(visited[0] < visited[a]) {
                        visited[0] = visited[a];
                        answer=1;
                    }else if(visited[0]==visited[a]){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}