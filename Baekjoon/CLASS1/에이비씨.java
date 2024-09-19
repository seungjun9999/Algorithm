package Baekjoon.CLASS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에이비씨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        System.out.println(a + b - c);
        int abc = Integer.parseInt(String.valueOf(a) + String.valueOf(b)) - c;
        System.out.println(abc);
    }
}