import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int end = n;
        int start = n - 1;
        int sum = 0;
        int cnt = 1;
        while (start >= 1) {
            int dep = end - start;
            if (dep % 2 == 1) {
                sum = (end + start) * (dep / 2 + 1);
            } else {
                sum = (end + start) * (dep / 2) + (end + start) / 2;
            }
            if (sum == n) {
                cnt++;
                end--;
                start = end-1;
            }
            else if(sum>n) {
                end--;
                if(end==start) start--;
            }
            else start--;
        }
        System.out.print(cnt);
    }
}