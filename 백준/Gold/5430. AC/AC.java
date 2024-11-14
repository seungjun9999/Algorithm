import java.io.*;
import java.util.*;

public class Main {
    static ArrayDeque<Integer> ad;
    static String arr;
    static int n;
    static boolean left;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            arr = br.readLine();
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
            ad = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                ad.add(Integer.parseInt(st.nextToken()));
            }
            acfunction();

        }
        System.out.print(sb);
    }

    static void acfunction() {
        left = true;

        for (int i = 0; i < arr.length(); i++) {
            char c = arr.charAt(i);
            if (c == 'R') {
                left = !left;
            } else {
                if (ad.isEmpty()) {
                    sb.append("error").append("\n");
                    return;
                }
                if (left) {
                    ad.pollFirst();
                } else {
                    ad.pollLast();
                }
            }
        }
        arrput();
    }

    static void arrput() {
        sb.append("[");
        int s = ad.size();
        for (int i = 0; i < s; i++) {
            if (left) {
                sb.append(ad.pollFirst());
            } else {
                sb.append(ad.pollLast());
            }
            if (i != s - 1) {
                sb.append(",");
            }
        }
        sb.append("]").append("\n");
    }
}