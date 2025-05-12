import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        int miin = Integer.MAX_VALUE;
        int maax = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            miin = Math.min(num[i], miin);
            maax += num[i];
        }
        int result = 0;
        while (miin <= maax) {
            int mid = (maax + miin) / 2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                sum += num[i];
                if (sum >= mid) {
                    sum = 0;
                    cnt++;
                }
            }
            if (cnt >= k) {
                result = mid;
                miin = mid + 1;
            } else {
                maax = mid - 1;
            }
        }
        System.out.print(result);
    }
}