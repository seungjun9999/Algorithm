import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int trues = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        HashSet<Integer> party = new HashSet<>();



        for (int i = 0; i < trues; i++) {
            int a = Integer.parseInt(st.nextToken());
            dq.offer(a);
            visited[a] = true;
        }

        HashMap<Integer, ArrayList<Integer>> people = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> partys = new HashMap<>();

        for(int i=1;i<=n;i++) {
            people.put(i,new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            partys.put(i, new ArrayList<>());
            for(int j=0;j<k;j++) {
                int a = Integer.parseInt(st.nextToken());
                partys.get(i).add(a);
                people.get(a).add(i);
            }
        }

        while (!dq.isEmpty()) {
            ArrayList<Integer> whatparty = new ArrayList<>(people.get(dq.poll()));
            for (int b : whatparty) {
                party.add(b);
                ArrayList<Integer> whopeople = new ArrayList<>(partys.get(b));
                for(int c: whopeople) {
                    if(!visited[c]) {
                        dq.offer(c);
                        visited[c] = true;
                    }
                }
            }
        }
        System.out.println(m - party.size());
    }
}