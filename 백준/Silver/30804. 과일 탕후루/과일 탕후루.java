import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int maax = 0;
        for (int end = 0; end < n; end++) {
            hm.put(num[end], hm.getOrDefault(num[end], 0) + 1);
            while (hm.size() > 2) {
                hm.put(num[start], hm.get(num[start]) - 1);
                if (hm.get(num[start]) == 0) {
                    hm.remove(num[start]);
                }
                start++;
            }
            maax = Math.max(maax, end - start + 1);
        }
        System.out.println(maax);
    }
}
