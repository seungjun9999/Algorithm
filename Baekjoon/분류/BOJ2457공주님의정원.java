import java.io.*;
import java.util.*;

public class BOJ2457공주님의정원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] flower = new int[n][2];
        int mys = 301;
        int mye = 0;
        int cnt = 0;
        int idx = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            flower[i][0] = a * 100 + b;
            flower[i][1] = c * 100 + d;
        }
        Arrays.sort(flower, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        while (mys < 1201) {

            boolean find = false;

            for (int i = idx; i < n; i++) {
                if (flower[i][0] > mys) {
                    break;
                }

                if (mye < flower[i][1]) {
                    find = true;
                    mye = flower[i][1];
                    idx = i + 1;
                }
            }

            if (find) {
                mys = mye;
                cnt++;
            } else {
                break;
            }

        }
        if (mye < 1201) {
            System.out.println(0);
        } else {
            System.out.println(cnt);
        }

    }
}
