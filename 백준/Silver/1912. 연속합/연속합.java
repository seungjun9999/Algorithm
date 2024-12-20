import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num, dp;
        num = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int result = num[0];
        dp[0] = num[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}