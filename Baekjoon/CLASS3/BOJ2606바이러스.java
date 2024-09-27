package Baekjoon.CLASS3;

import java.io.*;
import java.util.*;

public class BOJ2606바이러스 {
    static Queue<Integer> queue = new LinkedList<>();
    static int n, m, result = 0;
    static int[][] num;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        num = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            num[a][b] = 1;
            num[b][a] = 1;
        }
        queue.offer(1);
        visited[1] = true;
        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int put = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (num[put][i] == 1 && !visited[i]) {
                    result++;
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }
}
