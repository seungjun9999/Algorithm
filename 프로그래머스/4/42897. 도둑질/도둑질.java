class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] dp = new int[n];
        boolean[] visited = new boolean[n];
        visited[0] = true;
        visited[2] = true;
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = money[2] + dp[0];
        for(int i=3;i<n;i++) {
            if(dp[i-2] >= dp[i-3]) {
                dp[i] = dp[i-2] + money[i];
                if(visited[i-2]) {
                    visited[i] = true;
                }
            }else {
                dp[i] = dp[i-3] + money[i];
                if(visited[i-3]) {
                    visited[i] = true;
                }
            }
        }
        if(visited[n-1]) {
            dp[n-1] = dp[n-1] - Math.min(money[0],money[n-1]);
        }
        int sum1 = Math.max(dp[n-1],dp[n-2]);
        
        dp = new int[n];
        visited = new boolean[n];
        visited[n-1] = true;
        visited[n-3] = true;
        dp[n-1] = money[n-1];
        dp[n-2] = money[n-2];
        dp[n-3] = dp[n-1] + money[n-3];
        
        for(int i=n-4;i>=0;i--) {
            if(dp[i+2] >= dp[i+3]) {
                dp[i] = dp[i+2] + money[i];
                if(visited[i+2]) {
                    visited[i] = true;
                }
            }else {
                dp[i] = dp[i+3] + money[i];
                if(visited[i+3]) {
                    visited[i] = true;
                }
            }
        }
        if(visited[0]) {
            dp[0] = dp[0] - Math.min(money[0],money[n-1]);
        }
        int sum2 = Math.max(dp[0],dp[1]);
        
        
        return Math.max(sum1,sum2);
    }
}