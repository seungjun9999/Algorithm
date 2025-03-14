import java.io.*;
import java.util.*;

public class Main {
    static char[][] num;
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        num = new char[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            num[i] = arr.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (num[i][j] == '1') {
                    dq.offer(new int[]{i, j});
                    num[i][j] = '0';
                    int cnt = 1;
                    answer++;
                    while (!dq.isEmpty()) {
                        int[] now = dq.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = dx[k] + now[0];
                            int y = dy[k] + now[1];
                            if (!check(x, y) || num[x][y] == '0') continue;
                            dq.offer(new int[]{x, y});
                            num[x][y] = '0';
                            cnt++;
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(answer);
        for (int a : list) {
            System.out.println(a);
        }
    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
