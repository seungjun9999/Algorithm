import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] now = {0, 0};
        int[][] num = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
            num[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num, (o1, o2) -> o1[1] - o2[1]);
        int flag = 0;
        for (int i = 0; i < m; i++) {
            if (num[i][0] == 1) {
                if (num[i][2] > now[1] - (num[i][1] - now[0])) {
                    now = new int[]{num[i][1], now[1] - (num[i][1] - now[0])};
                } else {
                    flag = 1;
                    break;
                }
            } else {
                if (num[i][2] < now[1] - (num[i][1] - now[0])) {
                    now = new int[]{num[i][1], now[1] - (num[i][1] - now[0])};
                } else {
                    now = new int[]{num[i][1], num[i][2] + 1};
                }

            }
        }

        if (now[1] - ((n - 1) - now[0]) <= 1 && flag != 1) {
            System.out.print("stay");
        } else {
            System.out.print("adios");
        }
    }
}