import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] num;
    static int r, c, k,d;
    static int[] dx = {0,-1,0,1,0};
    static int[] dy = {0,0,1,0,-1};
    static ArrayList<int[]> gol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r+=3;
        num = new int[r][c];
        int answer=0;

        for(int t=1;t<=k;t++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            
            d = Integer.parseInt(st.nextToken());
            makeGol(start,t);

            while(true) {
                if(goSouth(t)) continue;
                if(goWest(t)) continue;
                if(goEast(t)) continue;
                break;
            }

            int[] center = gol.get(0);
            if(center[0]<4) {
                num = new int[r][c];
                continue;
            }

            num[center[0] + dx[d+1]][center[1] + dy[d+1]] = -t;
            
            answer+=bfs(center);
        }
        System.out.println(answer);
    }

    static private int bfs(int[] center) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];

        dq.offer(center);
        visited[center[0]][center[1]] = true;

        int maax = 0 ;
        while(!dq.isEmpty()) {
            int[] now = dq.poll();
                for(int i=1;i<5;i++) {
                    int x = dx[i] + now[0];
                    int y = dy[i] + now[1];
                    if(!check(x,y) || visited[x][y]) continue;

                    if(num[now[0]][now[1]]<0) {
                        if(num[x][y] == 0) continue;
                        dq.offer(new int[] {x,y});
                        visited[x][y] = true;
                        maax = Math.max(maax, x);
                    } else {
                        if(num[x][y] == num[now[0]][now[1]] || num[x][y] == -1*num[now[0]][now[1]]) {
                            dq.offer(new int[]{x,y});
                            visited[x][y] = true;
                            maax = Math.max(maax, x);
                        }
                    } 
                }
        }

        return maax - 2;
    }

    static private void makeGol(int start, int t) {
        gol = new ArrayList<>();

        for(int i=0;i<5;i++) {
            int x = dx[i] + 1;
            int y = dy[i] + start -1;
            gol.add(new int[] {x,y});
        }
        
        for(int[] g : gol) {
            num[g[0]][g[1]] = t;
        }
    }

    static private boolean goSouth(int t) {
        int[] center = gol.get(0);

        if(checkNorth()) {
            ArrayList<int[]> temp = new ArrayList<>();

            for(int[] g : gol) {
                num[g[0]][g[1]] = 0;
                temp.add(new int[] {g[0]+1, g[1]});
            }

            for(int[] tp : temp) {
                num[tp[0]][tp[1]] = t;
            }

            gol.clear();
            gol.addAll(temp);
            return true;
        }

        return false;
    }

    static private boolean goWest(int t) {
        
        if(checkWest()) {
            ArrayList<int[]> temp = new ArrayList<>();

            for(int[] g : gol) {
                num[g[0]][g[1]] = 0;
                temp.add(new int[] {g[0]+1,g[1]-1});
            }

            for(int[] tp : temp) {
                num[tp[0]][tp[1]] = t;
            }

            gol.clear();
            gol.addAll(temp);
            d-=1;
            if(d<0) {
                d=3;
            }
            return true;
        }
        
        return false;
    }

    static private boolean goEast(int t) {
        if(checkEast()) {

            ArrayList<int[]> temp = new ArrayList<>();

            for(int[] g : gol) {
                num[g[0]][g[1]] = 0;
                temp.add(new int[] {g[0]+1,g[1]+1});
            }

            for(int[] tp : temp) {
                num[tp[0]][tp[1]] = t;
            }

            gol.clear();
            gol.addAll(temp);

            d++;
            d%=4;

            return true;
        }
        return false;
    }

    static private boolean checkNorth() {
        int[] center = gol.get(0);

        return check(center[0]+2,center[1]) && num[center[0]+2][center[1]] ==0 && num[center[0]+1][center[1]-1]==0 && num[center[0]+1][center[1]+1]==0;
    }

    static private boolean checkWest() {
        int[] center = gol.get(0);


        return check(center[0]-1,center[1]-1) && num[center[0]-1][center[1]-1] == 0 && check(center[0],center[1]-2) && num[center[0]][center[1]-2] == 0 && check(center[0]+1,center[1]-1) && num[center[0]+1][center[1]-1] == 0 && check(center[0]+1,center[1]-2) && num[center[0]+1][center[1]-2] == 0 && check(center[0]+2,center[1]-1) && num[center[0]+2][center[1]-1] == 0;
    }

    static private boolean checkEast() {
        int[] center = gol.get(0);

        return check(center[0]-1,center[1]+1) && num[center[0]-1][center[1]+1] == 0 && check(center[0],center[1]+2) && num[center[0]][center[1]+2] == 0 && check(center[0]+1,center[1]+1) && num[center[0]+1][center[1]+1] == 0 && check(center[0]+1,center[1]+2) && num[center[0]+1][center[1]+2] == 0 && check(center[0]+2,center[1]+1) && num[center[0]+2][center[1]+1] == 0;
    }

    static private boolean check(int x,int y) {
        return x>=0 && x<r && y>=0 && y<c ;
    }
}