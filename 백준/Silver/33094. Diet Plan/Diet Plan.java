import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, result = 0;
    static int[] num;
    static PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                pq.offer(num[j]);
            }
            int s = check(m, k, pq.size());
            if (s == 0) {
                break;
            } else {
                result = s;
            }
        }
        System.out.println(result);
    }

    static int check(int sum, int cnt, int size) {
        while (!pq.isEmpty()) {
            if (cnt != 0) {
                pq.poll();
                cnt--;
            } else {
                sum -= pq.poll();
            }
        }
        if (sum >= 0) {
            return size;
        } else {
            return 0;
        }
    }
}