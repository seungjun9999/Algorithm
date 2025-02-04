import java.util.*;

class Solution {
    static int len,answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        len = dungeons.length;
        visited = new boolean[len];
        return findDungeon(k,answer, dungeons);
    }
    
    private int findDungeon(int piro,int cnt, int[][] dungeons){
        answer = Math.max(cnt,answer);
        
        for(int i = 0; i < len; i++) {
            if(!visited[i] && piro >= dungeons[i][0]) {
                visited[i] = true;
                findDungeon(piro - dungeons[i][1] ,cnt+1, dungeons);
                visited[i] = false;
            } 
        }
        
        return answer;
    }
}