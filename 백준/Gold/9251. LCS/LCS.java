import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr1 = br.readLine();
        String arr2 = br.readLine();
        int max=0;
        int n = arr1.length();
        int m = arr2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char a1 = arr1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                if (a1 == arr2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(dp[i][j],max);
            }
        }
        System.out.println(max);
    }
}
