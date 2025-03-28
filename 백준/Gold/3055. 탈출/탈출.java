import java.io.*;
import java.util.*;

public class Main {
    static int r, c, answer = 0;
    static char[][] map;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String arr = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = arr.charAt(j);
                if (map[i][j] == '*') {
                    list.add(new int[]{i, j, 0});
                } else if (map[i][j] == 'S') {
                    dq.offer(new int[]{i, j, 0});
                }
            }
        }
        for (int[] a : list) {
            dq.offer(a);
        }
        bfs();
        if (answer != 0) {
            System.out.println(answer);
        } else {
            System.out.println("KAKTUS");
        }
    }

    static private void bfs() {
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + now[0];
                int y = dy[i] + now[1];
                if (!check(x, y) || map[x][y] == 'X' || map[x][y] == '*') continue;
                if (map[now[0]][now[1]] == '*') {
                    if (map[x][y] == '.' || map[x][y] == 'S') {
                        map[x][y] = '*';
                        dq.offer(new int[]{x, y, now[2] + 1});
                    }
                } else {
                    if (map[x][y] == '.') {
                        map[x][y] = 'S';
                        dq.offer(new int[]{x, y, now[2] + 1});
                    } else if (map[x][y] == 'D') {
                        answer = now[2] + 1;
                        return;
                    }
                }
            }

        }
    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}