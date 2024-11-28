import java.io.*;
import java.util.*;

public class Main {
    static int a, b, result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        while (b != a) {
            if (b < a || (b % 2 != 0 && b % 10 != 1)) {
                result = -1;
                break;
            }
            if (b % 2 == 0) {
                b /= 2;
            } else {
                b /= 10;
            }
            result++;
        }
        System.out.println(result);
    }
}