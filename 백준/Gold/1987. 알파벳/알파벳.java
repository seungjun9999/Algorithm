import java.io.*;
import java.util.*;


public class Main {
    static int r, c, answer = 1;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashSet<Character> hs = new HashSet<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        hs.add(map[0][0]);
        visited[0][0] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    static private void dfs(int a, int b, int dep) {
        answer = Math.max(dep, answer);

        for (int i = 0; i < 4; i++) {
            int x = dx[i] + a;
            int y = dy[i] + b;
            if (!check(x, y) || visited[x][y] || hs.contains(map[x][y])) continue;
            visited[x][y] = true;
            hs.add(map[x][y]);
            dfs(x, y, dep + 1);
            visited[x][y] = false;
            hs.remove(map[x][y]);
        }
    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}