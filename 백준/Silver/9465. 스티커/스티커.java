import java.io.*;
import java.util.*;

public class Main {
    static int t, n, result;
    static int[][] num;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        for (int q = 0; q < t; q++) {
            n = Integer.parseInt(br.readLine());
            result = -1;
            num = new int[2][n];
            dp = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    num[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if (n == 1) {
                sb.append(Math.max(num[0][0], num[1][0])).append("\n");
                continue;
            }
            dp[0][0] = num[0][0];
            dp[1][0] = num[1][0];
            dp[0][1] = num[0][1] + dp[1][0];
            dp[1][1] = num[1][1] + dp[0][0];
            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + num[0][i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + num[1][i];
            }
            for (int i = n - 2; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    result = Math.max(result, dp[j][i]);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}