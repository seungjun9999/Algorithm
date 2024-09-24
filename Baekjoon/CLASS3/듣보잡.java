package Baekjoon.CLASS3;

import java.io.*;
import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        HashSet<String> hs = new HashSet<>();
        TreeSet<String> ts = new TreeSet();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }

        String s;
        for (int i = 0; i < m; i++) {
            s = br.readLine();
            if (hs.contains(s))
                ts.add(s);
        }

        sb.append(ts.size()).append("\n");
        for (String arr : ts) {
            sb.append(arr).append("\n");
        }

        System.out.print(sb);
    }
}
