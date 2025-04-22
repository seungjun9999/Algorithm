import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int[][] room = new int[n][4];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][][][] dp = new int[n + 1][a + 1][n + 1][4];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= a; j++) {
                for (int k = 0; k <= n; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        
        dp[0][0][0][3] = 0;
        
        for (int day = 0; day < n; day++) {
            for (int rest = 0; rest <= a; rest++) {
                for (int study = 0; study <= day; study++) {  // 최대 'day'일까지 공부 가능
                    for (int last = 0; last < 4; last++) {
                        if (dp[day][rest][study][last] == -1) continue;  // 도달할 수 없는 상태
                        
                        int currentValue = dp[day][rest][study][last];
                        
                        dp[day+1][rest][study+1][0] = Math.max(dp[day+1][rest][study+1][0], 
                                                            currentValue + room[day][0]);
                        
                        dp[day+1][rest][study+1][1] = Math.max(dp[day+1][rest][study+1][1], 
                                                            currentValue + room[day][1]);
                        
                        if (last != 2) { 
                            dp[day+1][rest][study][2] = Math.max(dp[day+1][rest][study][2], 
                                                              currentValue + room[day][2]);
                        }
                        
                        if (rest < a) {  
                            dp[day+1][rest+1][study][3] = Math.max(dp[day+1][rest+1][study][3], 
                                                                currentValue + room[day][3]);
                        }
                    }
                }
            }
        }
        
        int result = -1;
        for (int rest = 0; rest <= a; rest++) {
            for (int study = b; study <= n; study++) {  
                for (int last = 0; last < 4; last++) {
                    if (dp[n][rest][study][last] != -1) {  
                        result = Math.max(result, dp[n][rest][study][last]);
                    }
                }
            }
        }
        
        System.out.println(result);
    }
}