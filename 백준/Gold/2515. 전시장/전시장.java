import java.io.*;
import java.util.*;

public class Main {
    static int[][] grim;
    static int n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        grim = new int[n][2];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grim[i] = new int[]{a, b};
        }

        Arrays.sort(grim, (o1, o2) -> o1[0] - o2[0]);

        dp[0] = grim[0][1];

        for (int i = 1; i < n; i++) {
            if (grim[i][0] - grim[i - 1][0] >= s) {
                dp[i] = dp[i - 1] + grim[i][1];
            } else {
                int j = search(i - 1, grim[i][0]);
                if (j != -1) {
                    dp[i] = Math.max(dp[i - 1], dp[j] + grim[i][1]);
                } else {
                    dp[i] = Math.max(dp[i - 1], grim[i][1]);
                }
            }
        }

        System.out.println(dp[n - 1]);
    }

    static private int search(int end, int height) {
        int start = 0;
        int re = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (height - grim[mid][0] < s) {
                end = mid - 1;
            } else {
                re = mid;
                start = mid + 1;

            }
        }
        return re;
    }
}