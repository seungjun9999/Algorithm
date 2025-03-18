import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        q:
        while (t-- > 0) {
            ArrayDeque<int[]> dq = new ArrayDeque<>();
            ArrayList<int[]> list = new ArrayList<>();
            HashSet<String> hs = new HashSet<>();
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] home = new int[2];
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new int[]{a, b});
            }
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] goal = new int[]{a, b};

            dq.offer(new int[]{home[0], home[1]});
            while (!dq.isEmpty()) {
                int[] now = dq.poll();
                if (Math.abs(now[0] - goal[0]) + Math.abs(now[1] - goal[1]) <= 1000) {
                    System.out.println("happy");
                    continue q;
                }
                for (int[] con : list) {
                    if (!hs.contains(con[0] + ", " + con[1]) && Math.abs(now[0] - con[0]) + Math.abs(now[1] - con[1]) <= 1000) {
                        dq.offer(new int[]{con[0], con[1]});
                        hs.add(con[0] + ", " + con[1]);
                    }
                }

            }
            System.out.println("sad");
        }
    }
}