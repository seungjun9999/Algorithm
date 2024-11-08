import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int n, r, c, size, result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, n);
        find(size, r, c);
    }

    static void find(int size, int r, int c) {
        if (size == 1) {
            System.out.println(result);
            exit(0);
        }

        if (r < size / 2 && c < size / 2) {
            find(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {
            result += (int) Math.pow(size / 2, 2);
            find(size / 2, r, c - (size / 2));
        } else if (r >= size / 2 && c < size / 2) {
            result += (int) Math.pow(size / 2, 2) * 2;
            find(size / 2, r - (size / 2), c);
        } else {
            result += (int) Math.pow(size / 2, 2) * 3;
            find(size / 2, r - (size / 2), c - (size / 2));
        }
    }
}