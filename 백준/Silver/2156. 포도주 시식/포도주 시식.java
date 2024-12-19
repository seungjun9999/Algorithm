import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num, dp;
        num = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = num[1];
        int result = dp[1];
        if (n > 1) {
            dp[2] = num[1] + num[2];
            result = dp[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 3] + num[i - 1], dp[i - 2]) + num[i], dp[i - 1]); // dp 점화식 찾기 oox,
                ult = Math.max(dp[i], result);
        }
        System.out.println(result);
    }
}