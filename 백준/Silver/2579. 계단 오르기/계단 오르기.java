import java.io.*;

public class Main {
    static int[] num, dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = num[1];
        if (n > 1) {
            dp[2] = num[1] + num[2];
        }

        System.out.println(dp());

    }
    static int dp() {
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + num[i - 1]) + num[i];
        }

        return dp[n];
    }
}
