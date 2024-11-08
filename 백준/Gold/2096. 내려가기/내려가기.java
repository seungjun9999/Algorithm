import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] num = new int[n + 1][3];
        int[][] dpmin = new int[n + 1][3];
        int[][] dpmax = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<3;i++){
            dpmin[1][i] = num[1][i];
            dpmax[1][i] = num[1][i];
        }
        for(int i=2;i<=n;i++){
            dpmin[i][0] = Math.min(dpmin[i-1][0],dpmin[i-1][1]) + num[i][0];
            dpmin[i][1] = Math.min(Math.min(dpmin[i-1][0],dpmin[i-1][1]),dpmin[i-1][2]) + num[i][1];
            dpmin[i][2] = Math.min(dpmin[i-1][1],dpmin[i-1][2]) + num[i][2];
            dpmax[i][0] = Math.max(dpmax[i-1][0],dpmax[i-1][1]) + num[i][0];
            dpmax[i][1] = Math.max(Math.max(dpmax[i-1][0],dpmax[i-1][1]),dpmax[i-1][2]) + num[i][1];
            dpmax[i][2] = Math.max(dpmax[i-1][1],dpmax[i-1][2]) + num[i][2];
        }
        int max = Math.max(Math.max(dpmax[n][0],dpmax[n][1]),dpmax[n][2]);
        int min = Math.min(Math.min(dpmin[n][0],dpmin[n][1]),dpmin[n][2]);
        System.out.println(max +" "+min);
    }
}
