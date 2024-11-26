import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] num,result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        result = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        backt(0,0);
        System.out.print(sb);
    }
    static void backt(int a,int cnt){
        if(cnt==m){
            for(int i=0;i<m;i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int t = 0;
        for(int i=a;i<n;i++){
            if(t!=num[i]){
                result[cnt] = num[i];
                t = num[i];
                backt(i,cnt+1);
            }
        }
    }
}