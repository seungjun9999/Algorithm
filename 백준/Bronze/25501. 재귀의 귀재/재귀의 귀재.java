import java.io.*;

public class Main {
    static String arr;
    static int n, start, end, cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr = br.readLine();
            start = 0;
            cnt = 0;
            end = arr.length() - 1;
            recursion();
        }
        System.out.print(sb);
    }

    static void recursion() {
        cnt++;
        if (start >= end) {
            sb.append("1 ").append(cnt).append("\n");
        } else if (arr.charAt(start) != arr.charAt(end)) {
            sb.append("0 ").append(cnt).append("\n");
        } else {
            start++;
            end--;
            recursion();
        }
    }
}