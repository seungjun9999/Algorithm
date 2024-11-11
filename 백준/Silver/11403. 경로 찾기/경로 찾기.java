import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>();
    static int n;
    static int[][] num;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                num[i][j] = a;
                if (a == 1) {
                    list.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                q.offer(list.get(i).get(j));
            }
            visited = new boolean[n];
            bfs(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int a) {
        while (!q.isEmpty()) {
            int now = q.poll();
            num[a][now] = 1;
            visited[now] = true;
            for (int i = 0; i < list.get(now).size(); i++) {
                if (!visited[list.get(now).get(i)]) {
                    q.offer(list.get(now).get(i));
                    visited[list.get(now).get(i)] = true;
                }
            }
        }
    }
}