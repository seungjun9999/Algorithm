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
}