import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            if (m == 0) {
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    sb.append(pq.poll()).append('\n');
                }
            } else {
                pq.offer(m);
            }
        }
        System.out.println(sb);
    }
}