import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int maax = 0;
        for (int i = 0; i < x; i++) {
            maax += num[i];
        }
        int answer = maax;
        int cnt = 1;

        for (int i = x; i < n; i++) {
            answer += num[i];
            answer -= num[i - x];
            if (answer > maax) {
                maax = answer;
                cnt = 1;
            } else if (answer == maax) {
                cnt++;
            }
        }
        if (maax == 0) {
            System.out.print("SAD");
        } else {
            System.out.println(maax);
            System.out.println(cnt);
        }
    }
}