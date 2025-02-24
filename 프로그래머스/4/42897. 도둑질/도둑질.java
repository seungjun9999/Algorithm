class Solution {
    static int[] dp, money;
    static boolean[] visited;
    static int n;

    public int solution(int[] money) {
        n = money.length;
        this.money = money;
        dp = new int[n];
        visited = new boolean[n];
        int sum1 = bottomTop();
        int sum2 = topBottom();

        return Math.max(sum1, sum2);
    }

    private int bottomTop() {
        visited[0] = true;
        visited[2] = true;
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = money[2] + dp[0];
        for (int i = 3; i < n; i++) {
            if (dp[i - 2] >= dp[i - 3]) {
                dp[i] = dp[i - 2] + money[i];
                if (visited[i - 2]) {
                    visited[i] = true;
                }
            } else {
                dp[i] = dp[i - 3] + money[i];
                if (visited[i - 3]) {
                    visited[i] = true;
                }
            }
        }
        if (visited[n - 1]) {
            dp[n - 1] = dp[n - 1] - Math.min(money[0], money[n - 1]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }

    private int topBottom() {
        dp = new int[n];
        visited = new boolean[n];
        visited[n - 1] = true;
        visited[n - 3] = true;
        dp[n - 1] = money[n - 1];
        dp[n - 2] = money[n - 2];
        dp[n - 3] = dp[n - 1] + money[n - 3];

        for (int i = n - 4; i >= 0; i--) {
            if (dp[i + 2] >= dp[i + 3]) {
                dp[i] = dp[i + 2] + money[i];
                if (visited[i + 2]) {
                    visited[i] = true;
                }
            } else {
                dp[i] = dp[i + 3] + money[i];
                if (visited[i + 3]) {
                    visited[i] = true;
                }
            }
        }
        if (visited[0]) {
            dp[0] = dp[0] - Math.min(money[0], money[n - 1]);
        }

        return Math.max(dp[0], dp[1]);
    }
}