
import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int answer = 0;
        int[] dp = new int[t.length()+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<dp.length;i++) {
            for(String str : strs) {
                int n = i-str.length();
               if(n>=0 && dp[n] != Integer.MAX_VALUE && t.substring(n,i).equals(str)) {
                   dp[i] = Math.min(dp[i],dp[n]+1);
               }
            }
        }    
        return dp[t.length()] == Integer.MAX_VALUE ? -1 : dp[t.length()];
    }
}