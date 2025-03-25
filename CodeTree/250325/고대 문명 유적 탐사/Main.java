import java.util.*;
import java.io.*;

public class Main {
    static int[] bomul, result;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int dep = 0;
        int[][] num = new int[5][5];
        bomul = new int[m];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            bomul[i] = Integer.parseInt(st.nextToken());
        }

        while (k-- > 0) {
            int turn = 0;
            result = new int[]{0, 0, 0, 360};
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {

                    int[] t;
                    t = rotate(j, i, deepCopy(num), 90);
                    if (isBetter(t, result)) {
                        result = t.clone();
                    }

                    t = rotate(j, i, deepCopy(num), 180);
                    if (isBetter(t, result)) {
                        result = t.clone();
                    }

                    t = rotate(j, i, deepCopy(num), 270);
                    if (isBetter(t, result)) {
                        result = t.clone();
                    }

                }
            }

            if (result[2] == 0) {
                break;
            }

            if (result[3] == 90) {
                result = rotate(result[0], result[1], num, 90);
            } else if (result[3] == 180) {
                result = rotate(result[0], result[1], num, 180);
            } else {
                result = rotate(result[0], result[1], num, 270);
            }

            turn += result[2];
            
            int a = 1;
            while (a != 0) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 4; j >= 0; j--) {
                        if (num[j][i] == 0) {
                            num[j][i] = bomul[dep++];
                        }
                    }
                }

                a = bfs(num);
                turn += a;
            }
            sb.append(turn).append(" ");

        }

        System.out.println(sb);

    }

    static private int[] rotate(int x, int y, int[][] temp, int degree) {

        int[][] ro = new int[3][3];

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                ro[i + 1][j + 1] = temp[i + x][j + y];
            }
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (degree == 90) {
                    temp[x + j][y - i] = ro[i + 1][j + 1];
                } else if (degree == 180) {
                    temp[x - i][y - j] = ro[i + 1][j + 1];
                } else if (degree == 270) {
                    temp[x - j][y + i] = ro[i + 1][j + 1];
                }
            }
        }

        int a = bfs(temp);

        return new int[]{x, y, a, degree};
    }

    static private boolean isBetter(int[] a, int[] b) {
        return a[2] > b[2] || (a[2] == b[2] && a[3] < b[3]);
    }

    static private int[][] deepCopy(int[][] num) {
        int[][] temp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            temp[i] = num[i].clone();
        }
        return temp;
    }

    static private int bfs(int[][] temp) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        int my = 0;

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j]) {
                    list = new ArrayList<>();
                    dq.offer(new int[]{i, j});
                    visited[i][j] = true;
                    list.add(new int[]{i, j});
                    while (!dq.isEmpty()) {
                        int[] now = dq.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = dx[k] + now[0];
                            int y = dy[k] + now[1];
                            if (!check(x, y) || visited[x][y] || temp[x][y] != temp[now[0]][now[1]]) continue;
                            dq.offer(new int[]{x, y});
                            visited[x][y] = true;
                            list.add(new int[]{x, y});
                        }
                    }

                    if (list.size() >= 3) {
                        my += list.size();
                        for (int[] d : list) {
                            temp[d[0]][d[1]] = 0;
                        }
                    }
                }
            }
        }

        return my;
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
