import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] num = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int miin = num[0];
        int maax = n;
        int answer = 0;
        while (miin <= maax) {
            int mid = (miin + maax) / 2;
            int flag = 0;
            boolean suc = true;
            for (int i = 0; i < m; i++) {
                if (num[i] - mid <= flag) {
                    flag = num[i] + mid;
                } else {
                    suc = false;
                    break;
                }
            }
            if (n > num[m - 1] + mid) suc = false;
            if (suc) {
                answer = mid;
                maax = mid - 1;
            } else {
                miin = mid + 1;
            }
        }
        System.out.println(answer);
    }
}