import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] num, temp;
    static int n, m, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        size = 0;
        int answer=0;

        num = new int[n][m];
        temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                temp[i][j] = num[i][j];
                if (num[i][j] != 0) {
                    size++;
                }
            }
        }

        while (true) {            
            if(warm()==0) {
                System.out.println(0);
                return;
            }
            answer++;
            if (!chain()) break;
        }
        System.out.println(answer);
    }

    static private int warm() {
        int flag=0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (num[i][j] != 0) {
                    flag=1;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (!check(x, y)) continue;
                        if (num[x][y] == 0 && temp[i][j] > 0) {
                            temp[i][j]--;
                            if (temp[i][j] == 0) size--;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            num[i] = temp[i].clone();
        }
        return flag;
    }

    static private boolean chain() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        int cnt=1;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (num[i][j] != 0) {
                    dq.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!dq.isEmpty()) {
                        int[] now = dq.poll();
                        for(int k=0;k<4;k++) {
                            int x = now[0] + dx[k];
                            int y = now[1] + dy[k];
                            if(!check(x,y) || num[x][y]==0 || visited[x][y]) continue;
                            dq.offer(new int[] {x,y});
                            cnt++;
                            visited[x][y] = true;
                        }
                    }
                    if(cnt==size) return true;
                    return false;
                }
            }
        }
        return true;
    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
