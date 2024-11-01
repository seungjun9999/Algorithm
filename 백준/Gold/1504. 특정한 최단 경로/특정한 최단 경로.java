import java.util.*;
import java.io.*;

public class Main
{
    static class Node implements Comparable<Node>{
        int end;
        int weight;

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    static int n, e, v1, v2, inf=200000000, sum1=0, sum2=0, miin;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> pq;



    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[n+1];

        for(int i = 0; i < n+1; i++){
            dist[i] = inf;
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,v));
            list.get(b).add(new Node(a,v));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());


        sum1 += stra(1,v1);
        sum1 += stra(v1,v2);
        sum1 += stra(v2,n);

        sum2 += stra(1,v2);
        sum2 += stra(v2,v1);
        sum2 += stra(v1,n);

        miin = Math.min(sum1,sum2);
        System.out.println(miin >= inf ? -1 : miin);
    }

    static int stra(int start, int end){
        visited = new boolean[n+1];
        pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            dist[i] = inf;
        }
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(!visited[now.end]){
                visited[now.end] = true;

                for(int i = 0; i < list.get(now.end).size(); i++){
                    Node recent = list.get(now.end).get(i);
                    if(!visited[recent.end] && dist[recent.end] > dist[now.end] + recent.weight) {
                        dist[recent.end] = dist[now.end] + recent.weight;
                        pq.offer(new Node(recent.end, dist[recent.end]));
                    }
                }
            }
        }

        return dist[end];
    }
}