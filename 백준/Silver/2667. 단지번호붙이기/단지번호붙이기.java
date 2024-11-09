import java.io.*;
import java.util.*;

public class Main {

    static int[][] num;
    static boolean[][] visited;
    static int n, x, y, m = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Integer>cnt = new ArrayList<>();
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(String.valueOf(arr.charAt(j)));
                if (num[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);
            if (!visited[now[0]][now[1]]) {
                visited[now[0]][now[1]] = true;
                q.offer(now);
                cnt.add(bfs());
            }
        }

        Collections.sort(cnt);
        System.out.println(cnt.size());
        for(int i=0;i<cnt.size();i++){
            System.out.println(cnt.get(i));
        }
    }

    static int bfs() {
        int plus = 0;

        while (!q.isEmpty()) {
            int[] where = q.poll();
            plus++;
            for (int i = 0; i < 4; i++) {
                x = dx[i] + where[0];
                y = dy[i] + where[1];
                if (check(x, y) && !visited[x][y] && num[x][y] == 1) {
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return plus;
    }

    static boolean check(int a, int b) {
        if (a >= 0 && a < n && b >= 0 && b < n) {
            return true;
        }
        return false;
    }
}
