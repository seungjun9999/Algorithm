import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] num = new int[n + 1];
        int[] dp = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < k; i++) {
            dp[i] = num[i] + dp[i - 1];
        }
        for (int i = k; i <= n; i++) {
            int one = dp[i - 1] + num[i];
            int get = dp[i - k] + c;
            if (one <= get) {
                dp[i] = one;
            } else {
                dp[i] = get;
            }
        }
        int cnt = n;
        while (cnt >= 1) {
            if (dp[cnt] == dp[cnt - 1] + num[cnt]) {
                cnt -= 1;
            } else {
                cnt -= k;
                list.add(cnt + 1);
            }
        }
        Collections.sort(list);
        sb.append(dp[n]).append("\n").append(list.size()).append("\n");
        for (int a : list) {
            sb.append(a).append(" ");
        }
        System.out.print(sb);
    }
}