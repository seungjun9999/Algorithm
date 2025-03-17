import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] visited = new int[f+1];
        visited[s] = 1;
        ArrayDeque<Integer>dq = new ArrayDeque<>();
        dq.offer(s);
        while(!dq.isEmpty()) {
            int now = dq.poll();
            if(now+u<=f && visited[now+u]==0) {
                visited[now+u] = visited[now]+1;
                dq.offer(now+u);
            }
            if(now-d>=1 && visited[now-d]==0) {
                visited[now-d] = visited[now]+1;
                dq.offer(now-d);
            }
            if(now+u==g || now-d==g) {
                break;
            }
        }
        if(visited[g]==0) {
            System.out.println("use the stairs");
        }else {
            System.out.println(visited[g]-1);
        }

    }
}