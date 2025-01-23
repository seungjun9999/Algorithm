import java.util.*;

class Solution {
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] num;
    static int n, m, result = 0;

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        map = new char[n][m];
        num = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    dq.offer(new int[]{i, j});
                    num[i][j] = 1;
                }
            }
        }
        while (!dq.isEmpty()) {
            int[] where = dq.poll();
            for (int i = 0; i < 4; i++) {
                int x = where[0] + dx[i];
                int y = where[1] + dy[i];
                if (!check(x, y) || num[x][y] != 0 || map[x][y] == 'X') continue;
                num[x][y] = num[where[0]][where[1]] + 1;
                if (map[x][y] == 'L') {
                    result += num[x][y];
                    num = new int[n][m];
                    dq = new ArrayDeque<>();
                    num[x][y] = 1;
                    dq.offer(new int[]{x, y});
                    break;
                }
                if (map[x][y] == 'E' && result != 0) {
                    result += num[x][y];
                    System.out.print(result);
                    return result - 2;
                }
                dq.offer(new int[]{x, y});
            }
        }
        return -1;
    }

    static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }
}