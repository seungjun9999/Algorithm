import java.io.*;
import java.util.*;

public class Main {
    static int n, x, sum, result = 0, start = 0, end, mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        Arrays.sort(num);
        end = n - 1;
        while (start < end) {
            mid = start + end / 2;
            sum = num[start] + num[end];
            if (x == sum) {
                start++;
                end--;
                result++;
            } else if (sum > x) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(result);
    }
}