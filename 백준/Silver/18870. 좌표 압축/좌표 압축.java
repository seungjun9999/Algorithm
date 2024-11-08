import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] num = new int[n];
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sorted[i] = num[i];
        }
        Arrays.sort(sorted);
        int v=0;
        for (int i : sorted) {
            if (!hm.containsKey(i)) {
                hm.put(i, v);
                v++;
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(hm.get(num[i])).append(" ");
        }
        System.out.println(sb);
    }
}