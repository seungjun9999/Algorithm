import java.io.*;
import java.util.*;

public class Main {
    static class Shark implements Comparable<Shark> {
        int x, y, s, d, z;

        Shark(int x, int y, int s, int d, int z) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            return o.z - this.z;
        }
    }

    static int R, C, M;
    static int[] recent = {-1, -1};
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static int[][] num;
    static PriorityQueue<Shark> pq = new PriorityQueue<>();
    static PriorityQueue<Shark> temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            num[r-1][c-1] = z;
            pq.offer(new Shark(r - 1, c - 1, s, d, z));
        }
        int answer = 0;
        for (int i = 0; i < C; i++) {
            answer += catchShark(i);
            sharkMove();
        }

        System.out.println(answer);
    }

    static private void sharkMove() {
        num = new int[R][C];
        temp = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Shark now = pq.poll();
            if (now.x == recent[0] && now.y == recent[1]) continue;
            int cy = (now.d == 1 || now.d == 2) ? (R - 1) * 2 : (C - 1) * 2;
            now.s %= cy;
            for (int i = 0; i < now.s; i++) {
                int a = now.x + dx[now.d];
                int b = now.y + dy[now.d];
                if (!check(a, b)) {
                    if (now.d == 1) now.d = 2;
                    else if (now.d == 2) now.d = 1;
                    else if (now.d == 3) now.d = 4;
                    else now.d = 3;
                }
                now.x += dx[now.d];
                now.y += dy[now.d];
            }
            if (num[now.x][now.y] == 0) {
                num[now.x][now.y] = now.z;
                temp.offer(new Shark(now.x, now.y, now.s, now.d, now.z));
            }
        }
        pq = new PriorityQueue<>(temp);
    }

    static private int catchShark(int t) {
        for (int i = 0; i < R; i++) {
            if (num[i][t] != 0) {
                recent = new int[]{i, t};
                return num[i][t];
            }
        }
        recent = new int[]{-1, -1};
        return 0;
    }

    static private boolean check(int a, int b) {
        return a >= 0 && a < R && b >= 0 && b < C;
    }
}