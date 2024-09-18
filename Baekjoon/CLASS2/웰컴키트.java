package Baekjoon.CLASS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] clothes = new int[6];
        for (int i = 0; i < 6; i++) {
            clothes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            if(clothes[i]%t ==0){
                sum += clothes[i] / t;
            }else{
                sum += clothes[i] / t + 1;
            }

        }
        System.out.println(sum);
        System.out.println(n / p + " " + n % p);

    }
}