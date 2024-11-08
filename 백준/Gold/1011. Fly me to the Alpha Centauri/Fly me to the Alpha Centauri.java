import java.io.*;
import java.util.*;

public class Main {
    static int n, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int dist = y-x;

            int sqrt = (int) Math.sqrt(dist);
            if(Math.pow(sqrt,2) == dist){
                System.out.println(sqrt*2-1);
            }else if(Math.pow(sqrt,2) + sqrt >= dist) {
                System.out.println(sqrt*2);
            }else{
                System.out.println(sqrt*2+1);
            }
        }
    }
}