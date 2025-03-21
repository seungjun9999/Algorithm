import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] day = new int[n + 1];
        int[] cost = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            day[i] = a;
            cost[i] = b;
        }
        for (int i = 1; i <= n; i++) {
            int d = i + day[i] - 1;
            if (d <= n) {
                dp[d] = Math.max(dp[i - 1] + cost[i], dp[d]);
                for (int j = d; j <= n; j++) {
                    dp[j] = Math.max(dp[d], dp[j]);
                }
            }

        }
        System.out.println(dp[n]);
    }
}