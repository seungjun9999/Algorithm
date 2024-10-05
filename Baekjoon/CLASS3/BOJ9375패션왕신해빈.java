package Baekjoon.CLASS3;

import java.io.*;
import java.util.*;

public class BOJ9375패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, Integer> hm;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            hm = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            int result = 1;
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String b = st.nextToken();
                hm.put(b, hm.getOrDefault(b, 0) + 1);
            }
            for (int val : hm.values()) {
                result *= val + 1;
            }
            System.out.println(result - 1);
        }
    }
}
