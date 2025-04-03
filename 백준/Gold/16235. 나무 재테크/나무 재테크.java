import java.io.*;
import java.util.*;

public class Main {

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    static int n, m, k;
    static int[][] yang, map;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static PriorityQueue<Tree> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        yang = new int[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                yang[i][j] = 5;
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            pq.offer(new Tree(x - 1, y - 1, z));
        }

        while (k-- > 0) {
            spring();
            fall();
            winter();
        }

        System.out.println(pq.size());
    }

    static private void spring() {
        ArrayList<Tree> list = new ArrayList<>();
        ArrayList<Tree> live = new ArrayList<>();
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Tree now = pq.poll();
            if (yang[now.x][now.y] >= now.age) {
                yang[now.x][now.y] -= now.age;
                live.add(new Tree(now.x, now.y, now.age + 1));
            } else {
                list.add(new Tree(now.x, now.y, now.age / 2));
            }
        }
        for (Tree a : list) {
            yang[a.x][a.y] += a.age;
        }
        for (Tree t : live) {
            pq.offer(t);
        }
    }

    static private void fall() {
        ArrayList<Tree> temp = new ArrayList<>(pq);
        ArrayList<Tree> newTree = new ArrayList<>();
        for (Tree tp : temp) {
            if (tp.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int a = dx[j] + tp.x;
                    int b = dy[j] + tp.y;
                    if (!check(a, b)) continue;
                    newTree.add(new Tree(a, b, 1));
                }
            }
        }

        for (Tree t : newTree) {
            pq.offer(t);
        }
    }

    static private void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                yang[i][j] += map[i][j];
            }
        }
    }

    static private boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}