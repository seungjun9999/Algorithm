import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        boolean[] visited = new boolean[reserve.length];
        for(int l : lost) {
            hs.add(l);
        }
        
        Arrays.sort(reserve);
        for(int i = 0; i<reserve.length; i++) {
            if(hs.contains(reserve[i])) {
                hs.remove(reserve[i]);
                visited[i]=true;
            }
        }
        for(int i = 0; i<reserve.length; i++) {
            if(visited[i]) continue;
            if(hs.contains(reserve[i]-1)) {
                hs.remove(reserve[i]-1);
            }else if(hs.contains(reserve[i]+1)) {
                hs.remove(reserve[i]+1);
            }
        }
        
        
        return n-hs.size();
    }
}