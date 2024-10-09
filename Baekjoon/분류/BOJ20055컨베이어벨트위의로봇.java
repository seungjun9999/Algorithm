import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 국민은행 대비 구현 1
public class BOJ20055컨베이어벨트위의로봇 {

    static int[][] num;
    static int cnt = 0, n, k, last, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        num = new int[n * 2][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            num[i][0] = Integer.parseInt(st.nextToken());
        }
        while (true) {
            result++;
            rotate();
            if (cnt >= k) {
                break;
            }
        }
        System.out.println(result);
    }

    static void rotate() {
        last = num[n * 2 - 1][0];
        for (int i = 2 * n - 1; i >= 1; i--) {
            num[i][0] = num[i - 1][0];
            num[i][1] = num[i - 1][1];
        }
        num[0][0] = last;
        num[0][1] = 0;
        if (num[n - 1][1] == 1) {
            num[n - 1][1] = 0;
        }
        for (int i = n - 2; i >= 1; i--) {
            if (num[i][1] == 1 && num[i + 1][1] == 0 && num[i + 1][0] > 0) {
                num[i][1]--;
                num[i + 1][1]++;
                num[i + 1][0]--;
                if (num[i + 1][0] == 0) {
                    cnt++;
                }
                if (num[n - 1][1] == 1) {
                    num[n - 1][1]--;
                }
            }
        }
        if (num[0][0] > 0) {
            num[0][0]--;
            num[0][1]++;
            if (num[0][0] == 0) {
                cnt++;
            }
        }
    }
}
