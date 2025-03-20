import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int answer = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int[] startR = new int[2];
        int[] startB = new int[2];

        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = arr.charAt(j);
                if (map[i][j] == 'R') startR = new int[]{i, j};
                else if (map[i][j] == 'B') startB = new int[]{i, j};
            }
        }

        dfs(startR, startB, 1, map);
        if(answer==11) {
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }

    static private void dfs(int[] r, int[] b, int cnt, char[][] map) {
        if (cnt > 10) return;

        char[][] initMap = new char[n][m];
        for(int i=0;i<n;i++) {
            initMap[i] = map[i].clone();
        }
        int[] initR = r.clone();
        int[] initB = b.clone();

        t:
        for (int i = 0; i < 4; i++) {

            int x = dx[i] + r[0];
            int y = dy[i] + r[1];

            int q = dx[i] + b[0];
            int w = dy[i] + b[1];

            if (map[x][y] == '.' || map[x][y] == 'O' || map[q][w]=='.') {
                int moveR = 1;
                int moveB = 1;
                boolean goalR = false;
                while (moveR == 1 || moveB == 1) {
                    if (map[x][y] == '#' || map[x][y] == 'B') {
                        moveR = 0;
                    } else if (map[x][y] == '.') {
                        map[x][y] = 'R';
                        map[r[0]][r[1]] = '.';
                        moveR = 1;
                        r = new int[]{x, y};
                    } else {
                        moveR = 0;
                        map[r[0]][r[1]] = '.';
                        goalR = true;
                    }

                    x = r[0] + dx[i];
                    y = r[1] + dy[i];

                    if (map[q][w] == '#' || map[q][w] == 'R') {
                        moveB = 0;
                    } else if (map[q][w] == '.') {
                        map[q][w] = 'B';
                        map[b[0]][b[1]] = '.';
                        moveB = 1;
                        b = new int[]{q, w};
                    } else {
                        r = initR.clone();
                        b = initB.clone();
                        for(int j=0;j<n;j++) {
                            map[j] = initMap[j].clone();
                        }
                        continue t;
                    }

                    q = b[0] + dx[i];
                    w = b[1] + dy[i];
                }
                if (goalR){
                    answer = Math.min(answer, cnt);
                    return;
                }

                dfs(r, b, cnt + 1, map);
                r = initR.clone();
                b = initB.clone();
                for(int j=0;j<n;j++) {
                    map[j] = initMap[j].clone();
                }
            }
        }
    }
}
