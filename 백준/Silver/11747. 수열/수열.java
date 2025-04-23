import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int cnt = 0;
        while (cnt < n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && cnt < n) {
                num[cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i <= 1000; i++) {
            hs.add(i);
        }
        for (int i = 0; i < n; i++) {
            hs.remove(num[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            hs.remove(num[i] * 10 + num[i + 1]);
        }
        for (int i = 0; i < n - 2; i++) {
            hs.remove(num[i] * 100 + num[i + 1] * 10 + num[i + 2]);
        }
        System.out.print(Collections.min(hs));
    }
}