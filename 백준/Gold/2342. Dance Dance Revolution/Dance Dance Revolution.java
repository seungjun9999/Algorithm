import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) break;
            list.add(a);
        }

        if (list.isEmpty()) {
            System.out.println(0);
            return;
        }

        int n = list.size();
        int[][][] dp = new int[n + 1][5][5];

        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, Integer.MAX_VALUE);

        dp[0][0][0] = 0; 

        for (int step = 0; step < n; step++) {
            int go = list.get(step);

            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    if (dp[step][left][right] == Integer.MAX_VALUE) continue;
                    
                    if (right != go) {
                        int cost = dp[step][left][right] + move(left, go);
                        dp[step + 1][go][right] = Math.min(dp[step + 1][go][right], cost);
                    }
                    
                    if (left != go) {
                        int cost = dp[step][left][right] + move(right, go);
                        dp[step + 1][left][go] = Math.min(dp[step + 1][left][go], cost);
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int left = 0; left < 5; left++) {
            for (int right = 0; right < 5; right++) {
                answer = Math.min(answer, dp[n][left][right]);
            }
        }

        System.out.println(answer);
    }

    static int move(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
}