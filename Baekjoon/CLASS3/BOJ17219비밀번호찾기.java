package Baekjoon.CLASS3;

import java.io.*;
import java.util.*;

public class BOJ17219비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> hm = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hm.put(st.nextToken(), st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            String result = hm.get(br.readLine());
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
