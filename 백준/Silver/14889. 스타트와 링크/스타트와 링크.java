import java.io.*;
import java.util.*;

public class Main {
    static int n, flag = 0, miin = Integer.MAX_VALUE;
    static int[][] num;
    static boolean[] visited;
    static ArrayList<Integer> start = new ArrayList<>();
    static ArrayList<Integer> link = new ArrayList<>();
    static HashSet<String> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        num = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);

        System.out.println(miin);
    }

    static private void dfs(int t, int dep) {
        if (flag == 1) return;
        if (dep == n / 2) {

            link = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) link.add(i);
            }
            StringBuilder first = new StringBuilder();
            StringBuilder second = new StringBuilder();
            for (int i = 0; i < start.size(); i++) {
                first.append(start.get(i)).append(", ");
            }
            for (int i = 0; i < link.size(); i++) {
                second.append(link.get(i)).append(", ");
            }
            if (hs.contains(first.toString()) || hs.contains(second.toString())) return;
            hs.add(first.toString());
            hs.add(second.toString());
            int a = hap(start);
            int b = hap(link);
            miin = Math.min(Math.abs(a - b), miin);
            if (miin == 0) flag = 1;
            return;
        }

        for (int i = t; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                start.add(i);
                dfs(i, dep + 1);
                start.remove(start.size()-1);
                visited[i] = false;
            }

        }
    }

    static private int hap(ArrayList<Integer> list) {
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                answer += num[list.get(i) - 1][list.get(j) - 1];
            }
        }
        return answer;
    }
}