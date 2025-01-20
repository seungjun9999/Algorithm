import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        int[] inDegree = new int[n + 1];
        int[] times = new int[n + 1];
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            result[i] = times[i];
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a != -1) {
                    list.get(a).add(i);
                    inDegree[i]++;
                } else break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int recent = dq.poll();
            for (int a : list.get(recent)) {
                result[a] = Math.max(result[a], result[recent] + times[a]);
                if(--inDegree[a] == 0) {
                    dq.offer(a);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}