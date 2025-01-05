import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, result = 0, start, end;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        start = 0;
        end = n;
        plan();

        System.out.println(result);
    }

    static void plan() {
        while (start <= end) {
            int cnt = k;
            int sum = m;

            int mid = (start + end) / 2;
            Integer[] copy = new Integer[mid];
            for (int i = 0; i < mid; i++) {
                copy[i] = num[i];
            }
            Arrays.sort(copy, Collections.reverseOrder());
            for (int i = 0; i < mid; i++) {
                if (cnt > 0) {
                    cnt--;
                } else {
                    sum -= copy[i];
                }
            }
            if (sum >= 0) {
                start = mid + 1;
                result = mid;
            }else{
                end = mid-1;
            }
        }
    }
}