import java.io.*;

public class BOJ2138전구와스위치 {
    static int n, cnt1 = 0, cnt2 = 1;
    static String arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[] sw1 = new char[n];
        char[] sw2 = new char[n];

        for (int i = 0; i < 2; i++) {
            arr = br.readLine();
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    sw1[j] = arr.charAt(j);
                    sw2[j] = arr.charAt(j);
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            if (sw2[i] == '0') {
                sw2[i] = '1';
            } else {
                sw2[i] = '0';
            }
        }

        for (int i = 1; i < n; i++) {
            if (sw1[i - 1] != arr.charAt(i - 1)) {
                change(sw1, i - 1);
                cnt1++;
            }
            if (sw2[i - 1] != arr.charAt(i - 1)) {
                change(sw2, i - 1);
                cnt2++;
            }
        }
        if (check(sw1, sw2)) {
            if (sw1[n - 1] == sw2[n - 1]) {
                System.out.println(Math.min(cnt1, cnt2));
            } else if (sw1[n - 1] == arr.charAt(n - 1)) {
                System.out.println(cnt1);
            } else {
                System.out.println(cnt2);
            }
            return;
        }
        System.out.println(-1);
    }

    static void change(char[] sw, int a) {
        for (int i = a; i < a + 3; i++) {
            if (i < n) {
                if (sw[i] == '0') {
                    sw[i] = '1';
                } else {
                    sw[i] = '0';
                }
            }
        }
    }

    static boolean check(char[] sw1, char[] sw2) {
        if (sw1[n - 1] != arr.charAt(n - 1) && sw2[n - 1] != arr.charAt(n - 1)) {
            return false;
        }
        return true;
    }
}
