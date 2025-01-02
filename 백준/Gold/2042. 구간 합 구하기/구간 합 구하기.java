import java.io.*;
import java.util.*;

public class Main {
    static long[] tree, num;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        num = new long[n + 1];

        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];

        for (int i = 1; i <= n; i++) {
            num[i] = Long.parseLong(br.readLine());
            update(1, 1, n, i, num[i]);
        }
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long dif = c - num[b];
                num[b] = c;
                update(1, 1, n, b, dif);
            } else {
                sb.append(sum(1, 1, n, b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void update(int node, int start, int end, int idx, long dif) {
        if (idx < start || idx > end) return;

        tree[node] += dif;

        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, dif);
            update(node * 2 + 1, mid + 1, end, idx, dif);
        }
    }

    static long sum(int node, int start, int end, int left, long right) {
        if (left > end || right < start) {
            return 0;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }
}