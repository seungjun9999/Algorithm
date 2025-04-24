import java.io.*;

public class Main {
    static long[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new long[n + 3];
        num[1]=1;
        num[2]=1;
        num[3]=1;
        System.out.println(fibo(n));
    }

    static private long fibo(int n) {
        if (num[n] != 0) return num[n];
        else return num[n] = fibo(n - 1) + fibo(n - 3);
    }
}