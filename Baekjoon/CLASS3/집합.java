package Baekjoon.CLASS3;

import java.io.*;
import java.util.*;

public class 집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int S = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("empty")) {
                S = 0;
            } else if (order.equals("all")) {
                S = (1 << 21) - 1;
            } else {
                int num = Integer.parseInt(st.nextToken());
                if (order.equals("add")) {
                    S |= (1 << num);
                } else if (order.equals("remove")) {
                    S &= ~(1 << num);
                } else if (order.equals("check")) {
                    sb.append((S & (1 << num)) == (1 << num) ? 1 : 0).append("\n");
                } else if (order.equals("toggle")) {
                    S ^= (1 << num);
                }
            }
        }
        System.out.println(sb);
    }
}
