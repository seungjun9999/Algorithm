import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int n, m, k, mod;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        mod = 1000000007;
        int[] num = new int[n + 1];


        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int tSize = (int) Math.pow(2, h + 1);
        tree = new long[tSize];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            update(1, 1, n, i, num[i]);
        }
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                num[b] = c;
                update(1, 1, n, b, c);
            } else {
                sb.append(times(1, 1, n, b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static long update(int node, int start, int end, int idx, int dif) {
        if (idx < start || idx > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = dif;
        }
        int mid = (start + end) / 2;
        return tree[node] = (update(node * 2, start, mid, idx, dif) * update(node * 2 + 1, mid + 1, end, idx, dif)) % mod;
    }

    static long times(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return (times(node * 2, start, mid, left, right) * times(node * 2 + 1, mid + 1, end, left, right)) % mod;
    }
}