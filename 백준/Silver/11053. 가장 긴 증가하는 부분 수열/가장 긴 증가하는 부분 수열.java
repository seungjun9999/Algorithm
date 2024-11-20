import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];
        int result = 1;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result,dp[i]);
                }
            }
        }
        System.out.println(result);
    }
}