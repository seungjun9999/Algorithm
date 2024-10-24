import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> qp = new PriorityQueue<>();
        PriorityQueue<Integer> qm = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                if (qp.isEmpty() && qm.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    if (qp.isEmpty()) {
                        sb.append(qm.poll()).append('\n');
                    } else if (qm.isEmpty()) {
                        sb.append(qp.poll()).append('\n');
                    } else {
                        if (qp.peek() >= Math.abs(qm.peek())) {
                            sb.append(qm.poll()).append('\n');
                        } else {
                            sb.append(qp.poll()).append('\n');
                        }
                    }
                }
            } else {
                if (a > 0) {
                    qp.offer(a);
                } else {
                    qm.offer(a);
                }
            }
        }
        System.out.println(sb);
    }
}