import java.io.*;
import java.util.*;

public class Main {
    static int n,m,miin = Integer.MAX_VALUE ;
    static ArrayList<int[]> ck = new ArrayList<>();
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> select = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a==1) home.add(new int[]{i,j});
                else if(a==2) ck.add(new int[]{i,j});
            }
        }

        dfs(0,0);
        System.out.print(miin);
    }

    static void dfs(int a,int dep) {
        if(dep==m) {
            calc();
            return;
        }

        for(int i=a;i<ck.size();i++) {
            select.add(ck.get(i));
            dfs(i+1,dep+1);
            select.remove(select.size()-1);
        }
    }

    static void calc() {
        int sum=0;
        for(int[] h : home) {
            int r = Integer.MAX_VALUE;
            for(int[] s : select) {
                int t = road(h,s);
                if(r > t) r = t;
            }
            sum+=r;
        }
        miin = Math.min(miin,sum);
    }

    static private int road(int[] a,int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}