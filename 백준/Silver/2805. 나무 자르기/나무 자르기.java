import java.io.*;
import java.util.*;

public class Main {
    static int start, end, mid, result;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        start = 0;
        end = tree[n - 1];
        while (start < end) {
            sum = 0;
            mid = (start + end) / 2;
            for (int i = n - 1; i >= 0; i--) {
                int cut = tree[i] - mid;
                if (cut > 0) {
                    sum += cut;
                } else {
                    break;
                }
            }
            if (sum > m) {
                start = mid + 1;
                result = mid;
            } else if (sum < m) {
                end = mid;
            } else {
                result = mid;
                break;
            }
        }
        System.out.println(result);
    }
}
