import java.util.*;

class Solution {
    static int n;
    static ArrayList<ArrayList<Integer>> lose = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> win = new ArrayList<>();
    public int solution(int n, int[][] results) {
        int answer = 0;
        this.n = n;
        
        for(int i=0;i<=n;i++){
            lose.add(new ArrayList<>());
            win.add(new ArrayList<>());
        }
        for(int[] result : results) {
            win.get(result[0]).add(result[1]);
            lose.get(result[1]).add(result[0]);
        }
        for(int i=1;i<=n;i++){
            bfs(win,i);
            bfs(lose,i);
        }
        for(int i=0;i<win.get(1).size();i++){
            System.out.println(win.get(1).get(i));
        }
        for(int i=1;i<=n;i++){
            if(win.get(i).size() + lose.get(i).size() == n-1) {
                answer++;
            }
        }
        return answer;
    }
    void bfs(ArrayList<ArrayList<Integer>> list,int idx){
        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        for(int i=0;i<=n;i++){
            temp.add(new ArrayList<>());
            temp.get(i).addAll(list.get(i));
        }        
        dq.offer(idx);
        visited[idx] = true;
        while(!dq.isEmpty()) {
            int now = dq.poll();
            for(int a : temp.get(now)) {
                if(!visited[a]) {
                    dq.offer(a);
                    visited[a] = true;
                    if(!list.get(idx).contains(a)){
                        list.get(idx).add(a);
                    }      
                }
            }
        }
    }
}