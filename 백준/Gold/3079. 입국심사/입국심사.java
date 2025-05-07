import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] times = new long[n];
        long maax = 0;
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
            maax = Math.max(maax, times[i]);
        }
        maax *= m;
        long miin = 1;
        long answer = 0;
        c : while (miin <= maax) {
            long mid = (miin + maax) / 2;
            long sum = 0;
            for (long time : times) {
                sum += mid / time;
                if(sum >= m) {
                    maax = mid - 1;
                    answer = mid;
                    continue c;
                }
            }

            miin = mid + 1;
        }
        System.out.println(answer);
    }
}