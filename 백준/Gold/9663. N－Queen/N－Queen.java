import java.io.*;

public class Main {
    static int n, result = 0;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        backt(0);
        System.out.println(result);
    }

    static void backt(int dep) {
        if (dep == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            num[dep] = i;
            if (check(dep)) {
                backt(dep + 1);
            }
        }
    }

    static boolean check(int c) {
        for (int i = 0; i < c; i++) {
            if (num[i] == num[c]) {
                return false;
            } else if (Math.abs(c - i) == Math.abs(num[i] - num[c])) {
                return false;
            }
        }
        return true;
    }

    // 미친 스피드런 방법 ㅋㅋ;;; 정답 바로 출력 ..
    // public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // int N = Integer.parseInt(br.readLine());
    // int[] nq = {1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712,
    // 365596, 2279184};
    // System.out.println(nq[N]);
    // }
}