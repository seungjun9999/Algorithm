import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, cnt;

        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int n, m, answer = -1, eCnt = 0;
    static int[][] num;
    static ArrayList<int[]> list = new ArrayList<>();
    static boolean[] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                if (num[i][j] == 2) {
                    list.add(new int[]{i, j});
                } else if (num[i][j] == 0) {
                    eCnt++;
                }
            }
        }
        visited = new boolean[list.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    static private void dfs(int a, int cnt) {
        if (cnt == m) {
            int r = bfs();
            if (r != -1 && answer != -1) {
                answer = Math.min(answer, r);
            } else if (r != -1 && answer == -1) {
                answer = r;
            }
            return;
        }

        for (int i = a; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
    }

    static private int bfs() {
        int emt = eCnt;
        if (emt == 0) return 0;
        ArrayDeque<Node> dq = new ArrayDeque<>();
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = num[i].clone();
        }
        int maax = -1;
        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) {
                int a = list.get(i)[0];
                int b = list.get(i)[1];
                dq.offer(new Node(a, b, -1));
                temp[a][b] = -1;
            }
        }
        while (!dq.isEmpty()) {
            Node now = dq.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + now.r;
                int y = dy[i] + now.c;
                if (check(x, y) && (temp[x][y] == 0 || temp[x][y] == 2)) {
                    if (temp[x][y] == 0) emt--;
                    dq.offer(new Node(x, y, now.cnt - 1));
                    temp[x][y] = now.cnt - 1;
                    maax = Math.max(maax, now.cnt * -1);
                }
            }
            if (emt == 0) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 0) return -1;
            }
        }

        return maax;
    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}