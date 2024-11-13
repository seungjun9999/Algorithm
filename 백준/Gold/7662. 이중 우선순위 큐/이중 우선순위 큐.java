import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                if (a.equals("I")) {
                    tm.put(b, tm.getOrDefault(b, 0) + 1);
                } else {
                    if (tm.isEmpty()) continue;
                    int target;
                    if (b == -1) {
                        target = tm.firstKey();
                    } else {
                        target = tm.lastKey();
                    }
                    tm.put(target, tm.get(target) - 1);
                    if (tm.get(target) == 0) {
                        tm.remove(target);
                    }
                }
            }
            if (tm.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(tm.lastKey() + " " + tm.firstKey()).append("\n");
            }
        }
        System.out.print(sb);
    }
}