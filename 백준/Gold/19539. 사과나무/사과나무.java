import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0, ocnt = 0, tcnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int tree = Integer.parseInt(st.nextToken());
            sum += tree;
            ocnt += tree % 2;
            tcnt += tree / 2;
        }

        if (sum % 3 != 0 || ocnt>tcnt) {
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }
}