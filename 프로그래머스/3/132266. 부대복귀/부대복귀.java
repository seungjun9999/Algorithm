import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list  = new ArrayList<>();
    static int[] visited;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        visited = new int[n+1];
        Arrays.fill(visited,-1);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
        }
        for(int[] road : roads) {
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        dq.offer(destination);
        visited[destination] = 0;
        while(!dq.isEmpty()) {
            int now = dq.poll();
            for(int a : list.get(now)) {
                if(visited[a]==-1) {
                    dq.offer(a);
                    visited[a] = visited[now] + 1;
                }
            }
        }
        for(int i=0;i<answer.length;i++) {
            answer[i] = visited[sources[i]];
        }
        return answer;
    }
}