import java.util.*;
import java.io.*;

public class Main
{
    static ArrayList<ArrayList<Integer>> listpt = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> listps = new ArrayList<>();
    static boolean[] person;
    static boolean[] visited;
    static int n,m,cnt;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = m;
        visited = new boolean[m];
        person = new boolean[n+1];

        for(int i = 0; i < n+1 ; i++){
            listps.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m ; i++){
            listpt.add(new ArrayList<Integer>());
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++){
            int a = Integer.parseInt(st.nextToken());
            q.offer(a);
            person[a] = true;
        }

        for(int i = 0; i < m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for(int j = 0; j < a; j++){
                int b = Integer.parseInt(st.nextToken());
                listps.get(b).add(i);
                listpt.get(i).add(b);
            }
        }

        bfs();
        System.out.println(cnt);
    }

    static void bfs(){
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < listps.get(now).size(); i++){
                int pt = listps.get(now).get(i);
                if(!visited[pt]){
                    visited[pt] = true;
                    cnt--;
                    for(int j = 0; j< listpt.get(pt).size(); j++){
                        int recent = listpt.get(pt).get(j);
                        if(!person[recent]){
                            q.offer(recent);
                            person[recent] = true;
                        }
                    }
                }
            }
        }
    }
}