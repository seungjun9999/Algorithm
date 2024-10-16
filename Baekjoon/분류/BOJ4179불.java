import java.io.*;
import java.util.*;

//bfs
public class BOJ4179불 {
    static int r, c, result = 0, jcnt = 1;
    static Character[][] miro;
    static int[] start;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static ArrayList<int[]> fire = new ArrayList<>();
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        miro = new Character[r][c];
        for (int i = 0; i < r; i++) {
            String arr = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = arr.charAt(j);
                if (c == 'F') {
                    fire.add(new int[] { i, j, 0 });
                } else if (c == 'J') {
                    start = new int[] { i, j, 0 };
                }
                miro[i][j] = arr.charAt(j);
            }
        }
        queue.offer(start);
        for (int i = 0; i < fire.size(); i++) {
            queue.offer(fire.get(i));
        }
        bfs();
        if (result == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] where = queue.poll();
            char recent = miro[where[0]][where[1]];
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + where[0];
                int y = dy[i] + where[1];
                if (recent == 'J') {
                    if (!check(x, y)) {
                        result = where[2] + 1;
                        return;
                    }
                    if (miro[x][y] == '.') {
                        miro[x][y] = 'J';
                        jcnt++;
                        queue.offer(new int[] { x, y, where[2] + 1 });
                    }
                } else {
                    if (check(x, y) && (miro[x][y] == '.' || miro[x][y] == 'J')) {
                        if (miro[x][y] == 'J') {
                            jcnt--;
                            if (jcnt == 0) {
                                return;
                            }
                        }
                        miro[x][y] = 'F';
                        queue.offer(new int[] { x, y, 0 });
                    }
                }

            }
        }
    }

    static boolean check(int x, int y) {
        if (x >= 0 && x < r && y >= 0 && y < c) {
            return true;
        }
        return false;
    }
}
