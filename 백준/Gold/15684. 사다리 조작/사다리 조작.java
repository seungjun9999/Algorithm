import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h, flag = 4;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static HashSet<String> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(new int[]{b + 1, a});
            list.get(b + 1).add(new int[]{b, a});
            hs.add(a + ", " + b);
        }

        dfs(0, 1, 1);
        if (flag == 4) {
            System.out.println(-1);
        } else {
            System.out.println(flag);
        }
    }

    static private void dfs(int dep, int a, int b) {
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (sadari(i, i, 0)) cnt++;
            else break;
        }

        if (cnt == n) {
            flag = Math.min(dep, flag);
            return;
        }


        if (dep == 3) {
            return;
        }

        for (int i = a; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (i == a && j < b) continue;
                if (check(i, j)) {
                    hs.add(i + ", " + j);
                    list.get(j).add(new int[]{j + 1, i});
                    list.get(j + 1).add(new int[]{j, i});
                    dfs(dep + 1, i, j);
                    list.get(j).remove(list.get(j).size() - 1);
                    list.get(j + 1).remove(list.get(j + 1).size() - 1);
                    hs.remove(i + ", " + j);
                }
            }
        }
    }

    static private boolean sadari(int start, int d, int v) {
        int miin = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int[] now : list.get(d)) {
            if (now[1] > v && now[1] - v < miin) {
                miin = now[1] - v;
                a = now[0];
                b = now[1];
            }
        }
        if (a == 0) {
            if (start == d) {
                return true;
            } else {
                return false;
            }
        } else {
            return sadari(start, a, b);
        }
    }

    static private boolean check(int i, int j) {
        return !hs.contains(i + ", " + (j - 1)) && !hs.contains(i + ", " + j) && !hs.contains(i + ", " + (j + 1));
    }
}
