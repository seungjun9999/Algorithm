import java.io.*;
import java.util.*;

public class Main {
    static int[][] num;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        num = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][2];

        dp[0][0] = num[0][0];
        dp[0][1] = num[0][1];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = num[i][j] + Math.max(
                        dp[i - 1][0] + Math.abs(num[i][(j + 1) % 2] - num[i - 1][1]),
                        dp[i - 1][1] + Math.abs(num[i][(j + 1) % 2] - num[i - 1][0])
                );
            }
        }
        System.out.print(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}