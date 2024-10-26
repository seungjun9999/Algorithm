import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static char[][] area1,area2;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        area1 = new char[n][n];
        area2 = new char[n][n];
        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            for (int j = 0; j < n; j++) {
                area1[i][j] = arr.charAt(j);
                if(arr.charAt(j)=='R'){
                    area2[i][j] = 'G';
                }else{
                    area2[i][j] = arr.charAt(j);
                }

            }
        }
        for (int k = 0; k < 2; k++) {
            visited = new boolean[n][n];
            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        q.offer(new int[]{i, j});
                        if(k==0){
                            bfs(area1);
                        }else{
                            bfs(area2);
                        }
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs(char[][] area) {
        while (!q.isEmpty()) {
            int[] where = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = where[0] + dx[i];
                int y = where[1] + dy[i];
                if (check(x, y) && area[where[0]][where[1]] == area[x][y] && !visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }

    }

    static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

}