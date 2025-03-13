import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Integer> hm;
    static int[] parent, size;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            hm = new HashMap<>();
            int cnt = 1;
            int f = Integer.parseInt(br.readLine());
            parent = new int[f * 2 + 1];
            size = new int[f * 2 + 1];
            for (int i = 1; i <= f * 2; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < f; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                if (!hm.containsKey(a)) {
                    hm.put(a, cnt++);
                }
                String b = st.nextToken();
                if (!hm.containsKey(b)) {
                    hm.put(b, cnt++);
                }
                union(a, b);
            }
        }
        System.out.println(sb);
    }

    static private void union(String a, String b) {
        int pA = find(hm.get(a));
        int pB = find(hm.get(b));

        if (pA != pB) {
            if (size[pA] < size[pB]) {
                parent[pA] = pB;
                size[pB] += size[pA];
                sb.append(size[pB]).append("\n");
            } else {
                parent[pB] = pA;
                size[pA] += size[pB];
                sb.append(size[pA]).append("\n");
            }
        } else {
            sb.append(size[pA]).append("\n");
        }
    }

    static private int find(int k) {
        if (parent[k] == k) return k;
        return find(parent[k]);
    }
}
