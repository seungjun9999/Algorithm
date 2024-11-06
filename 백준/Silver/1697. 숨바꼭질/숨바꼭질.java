import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int pos;
        int cnt;

        Node(int pos,int cnt){
            this.pos = pos;
            this.cnt = cnt;
        }
    }
    static Queue<Node> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        q.offer(new Node(n,0));
        visited[n] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.pos == k){
                System.out.println(now.cnt);
                break;
            }
            if(check(now.pos -1)&& !visited[now.pos -1 ]){
                visited[now.pos -1] = true;
                q.offer(new Node(now.pos-1, now.cnt+1));
            }
            if(check(now.pos +1) && !visited[now.pos +1 ]){
                visited[now.pos +1] = true;
                q.offer(new Node(now.pos+1, now.cnt+1));
            }
            if(check(now.pos *2) && !visited[now.pos *2 ]){
                visited[now.pos *2] = true;
                q.offer(new Node(now.pos*2, now.cnt+1));
            }
        }
    }

    static boolean check(int x){
        if(x>=0 && x<100001){
            return true;
        }
        return false;
    }
}
