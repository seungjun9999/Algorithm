import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long[] day = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            day[i] = Long.parseLong(st.nextToken());
        }
        long maax = 2_000_000_000L;
        long miin = 1;
        long result = 0;
        c:
        while (miin <= maax) {
            long sum = 0;
            long mid = (maax + miin) / 2;
            for (int i = 0; i < n - 1; i++) {
                long m = day[i + 1] - day[i];
                long s = Math.min(m, mid);
                sum += s * (mid + (mid - s + 1)) / 2;
                if (sum >= k) {
                    result = mid;
                    maax = mid - 1;
                    continue c;
                }
            }
            if (k - sum <= mid * (mid + 1) / 2) {
                result = mid;
                maax = mid - 1;
            } else {
                miin = mid + 1;
            }
        }
        System.out.println(result);
    }
}