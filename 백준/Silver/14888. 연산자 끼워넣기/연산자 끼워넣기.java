import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt, maax = Integer.MIN_VALUE, miin = Integer.MAX_VALUE;
    static int[] num, giho;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        giho = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        cnt = 0;
        for (int i = 0; i < 4; i++) {
            giho[i] = Integer.parseInt(st.nextToken());
            cnt += giho[i];
        }
        if (giho[0] > 0) {
            giho[0]--;
            dfs(num[0] + num[1], 1);
            giho[0]++;
        }

        if (giho[1] > 0) {
            giho[1]--;
            dfs(num[0] - num[1], 1);
            giho[1]++;
        }

        if (giho[2] > 0) {
            giho[2]--;
            dfs(num[0] * num[1], 1);
            giho[2]++;
        }

        if (giho[3] > 0) {
            giho[3]--;
            dfs(num[0] / num[1], 1);
            giho[3]++;
        }

        System.out.println(maax);
        System.out.println(miin);
    }

    static private void dfs(int now, int dep) {
        if (dep == cnt) {
            maax = Math.max(maax, now);
            miin = Math.min(miin, now);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (giho[i] == 0) continue;
            giho[i]--;
            if (i == 0) {
                dfs(now + num[dep + 1], dep + 1);
            } else if (i == 1) {
                dfs(now - num[dep + 1], dep + 1);
            } else if (i == 2) {
                dfs(now * num[dep + 1], dep + 1);
            } else {
                if (now < 0) {
                    now *= -1;
                    dfs((now / num[dep + 1]) * -1, dep + 1);
                } else {
                    dfs(now / num[dep + 1], dep + 1);
                }
            }
            giho[i]++;
        }
    }
}
