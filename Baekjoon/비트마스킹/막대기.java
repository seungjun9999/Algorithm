package Baekjoon.비트마스킹;

import java.io.*;

public class 막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int S = 64;
        int sum = 0, cnt = 0;

        while (S > 0) {
            if (sum + S == x) {
                cnt++;
                break;
            } else if (sum + S > x) {
                S = (S >> 1);
            } else {
                sum += S;
                cnt++;
                S = (S >> 1);
            }
        }
        System.out.println(cnt);
    }
}
