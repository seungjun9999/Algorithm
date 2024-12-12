import java.io.*;
import java.util.*;

public class Main {
    static int[] num, dpup, dpdw;
    static int n, maax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maax = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        dpup = new int[n];
        dpdw = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            dpup[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i] && dpup[i] < dpup[j] + 1) {
                    dpup[i] = dpup[j] + 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            dpdw[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (num[j] < num[i] && dpdw[i] < dpdw[j] + 1) {
                    dpdw[i] = dpdw[j] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int result = dpdw[i] + dpup[i] - 1;
            maax = Math.max(result, maax);
        }
        System.out.println(maax);
    }
}