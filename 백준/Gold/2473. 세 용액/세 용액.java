import java.io.*;
import java.util.*;

public class Main {
    static long[] num;
    static int n;
    static long sum = 3000000001L;
    static long[] result = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        for (int i = 0; i < n - 2; i++) {
            select(i);
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static void select(int i) {
        int start = i + 1;
        int end = num.length - 1;
        while (start < end) {
            long hap = num[start] + num[end] + num[i];
            if (Math.abs(hap) < sum) {
                sum = Math.abs(hap);
                result[0] = num[i];
                result[1] = num[start];
                result[2] = num[end];
            }
            if (hap == 0) {
                break;
            } else if (hap > 0) {
                end--;
            } else {
                start++;
            }
        }
    }
}
