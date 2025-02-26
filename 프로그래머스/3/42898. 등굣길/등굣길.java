import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] num = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int[] pud : puddles) {
            visited[pud[1]-1][pud[0]-1] = true;
        }
        for(int i=0;i<n;i++) {
            if(!visited [i][0]) num[i][0] = 1;
            else break;
        }
        for(int i=1;i<m;i++) {
            if(!visited[0][i]) num[0][i] = 1;
            else break;
        }
        
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(visited[i][j]) continue;
                num[i][j] = (num[i-1][j] + num[i][j-1])%1_000_000_007;
            }
        }
        
        return num[n-1][m-1];
    }
}