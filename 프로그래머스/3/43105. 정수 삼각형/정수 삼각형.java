class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int answer = 0;
        int[][] dp = new int[n][];
        for(int i=0;i<n;i++) {
            dp[i] = triangle[i].clone();
        }
        for(int i = 0; i < n - 1 ;i++) {
            for(int j=0;j<triangle[i].length; j++) {
                dp[i+1][j] = Math.max(dp[i][j]+triangle[i+1][j] , dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i][j]+triangle[i+1][j+1] , dp[i+1][j+1]);
            }
        }
        for(int temp : dp[n-1]) {
            answer = Math.max(answer,temp);
        }
        return answer;
    }
}