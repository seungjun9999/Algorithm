import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 1;
        long sum = 0;
        Arrays.sort(num);
        for (int i = 0; i < n; i++) {
            int r = num[i] - cnt;
            if(r==0) {
                int a = i;
                while (a + 1 < n && num[a] == num[a + 1]) {
                    a++;
                }
                i = a;
            }
            sum += r;
            cnt++;
        }
        System.out.print(sum);
    }
}