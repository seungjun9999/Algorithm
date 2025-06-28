import java.io.*;
import java.util.*;

public class Main {
    static int n, result = Integer.MAX_VALUE;
    static int[] ssum;
    static int[] ssin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ssin = new int[n];
        ssum = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ssin[i] = Integer.parseInt(st.nextToken());
            ssum[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, 1, 0);
        System.out.print(result);
    }

    static private void dfs(int a,int dep, int sin, int sum) {
        if(a!=0) {
            result = Math.min(result, Math.abs(sin - sum));
        }
        for (int i = dep; i < n; i++) {
            dfs(a+1,i+1, sin * ssin[i], sum + ssum[i]);
        }
    }
}
