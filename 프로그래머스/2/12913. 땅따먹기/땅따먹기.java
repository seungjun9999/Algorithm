class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int answer = 0;
        int[][] dp = new int[n][4];
        dp[0] = land[0].clone();
        for(int i=1;i<n;i++) {
            for(int j=0;j<4;j++) {
                for(int k=0;k<4;k++) {
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][k] + land[i][j]);
                }
            }
        }
        for(int a : dp[n-1]) {
            answer = Math.max(a,answer);
        }
        return answer;
    }
}