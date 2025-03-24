import java.io.*;
import java.util.*;

public class Main {
    static int n, answer, v, flag = 0;
    static int[][] num;
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayDeque<int[]> list = new ArrayDeque<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        num[0][0] = 2;
        list.offer(new int[]{0, 0});
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            num[a - 1][b - 1] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            hm.put(a, b);
        }

        dfs(0, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int nowx, int nowy, int cnt) {
        if (flag == 1) return;
        int x = nowx + dx[v];
        int y = nowy + dy[v];
        if (!check(x, y) || num[x][y] == 2) {
            answer = cnt;
            flag = 1;
            return;
        } else if (num[x][y] == 1) {
            num[x][y] = 2;
        } else {
            num[x][y] = 2;
            int[] where = list.poll();
            num[where[0]][where[1]] = 0;
        }
        list.offer(new int[]{x, y});
        if (hm.containsKey(cnt)) {
            if (hm.get(cnt).equals("D")) {
                v = (v + 1) % 4;
            } else {
                v = v - 1;
                if (v < 0) {
                    v = 3;
                }
            }
        }
        dfs(x, y, cnt + 1);
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}