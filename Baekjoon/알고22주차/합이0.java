package Baekjoon.알고22주차;

import java.io.*;
import java.util.*;

public class 합이0 {

    static int n;
    static long cnt = 0;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        for (int i = 0; i < n; i++) {
            if (num[i] > 0) {
                break;
            }
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int hap = num[i] + num[start] + num[end];
                if (hap == 0) {
                    cnt++;
                }
                if (hap > 0) {
                    end--;
                } else {
                    start++;
                }

            }
        }
        System.out.println(cnt);
    }

}
