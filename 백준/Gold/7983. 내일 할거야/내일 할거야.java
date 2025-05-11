import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num, ((o1, o2) -> o2[1] - o1[1]));
        int now = num[0][1];
        for (int i = 0; i < n-1; i++) {
            now = now - num[i][0];
            now = Math.min(now, num[i + 1][1]);
        }
        System.out.print(now - num[n - 1][0]);
    }
}