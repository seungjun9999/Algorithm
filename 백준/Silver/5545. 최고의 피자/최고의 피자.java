import java.io.*;
import java.util.*;

public class Main {
    static int[] tCal;
    static int dou, top, dCal, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dou = Integer.parseInt(st.nextToken());
        top = Integer.parseInt(st.nextToken());

        dCal = Integer.parseInt(br.readLine());
        tCal = new int[n];
        for (int i = 0; i < n; i++) {
            tCal[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tCal);
        int sum = dCal;
        int bestCal = dCal / dou;
        int cnt = 1;
        for (int i = n - 1; i >= 0; i--) {
            sum += tCal[i];
            bestCal = Math.max(bestCal, sum / (dou + (top * (cnt++))));
        }
        System.out.print(bestCal);
    }
}
