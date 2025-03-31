import java.io.*;
import java.util.*;

public class Main {
    static int n,l,cnt=0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cntRoad(map);
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = map[n-1-j][i];
            }
        }
        cntRoad(arr);
        System.out.print(cnt);
    }

    static private void cntRoad(int[][] num) {
        for(int i=0;i<n;i++) {
            visited = new boolean[n][n];
            for(int j=0;j<n;j++) {
                if(j==n-1) {
                    cnt++;
                    break;
                }
                if(num[i][j] - num[i][j+1] == 1){
                    if(down(num,i,j)) {
                        j+=l-1;
                    }else {
                        break;
                    }
                }else if(num[i][j] - num[i][j+1] == -1) {
                    if(!up(num,i,j)) {
                        break;
                    }
                }else if(num[i][j]!=num[i][j+1]) {
                    break;
                }
            }
        }
    }

    static private boolean down (int[][] num, int x,int y) {
        for(int i= y+1; i<=y+l;i++) {
            if(i>=n||num[x][y+1]!=num[x][i] || visited[x][i]) {
                return false;
            }
            visited[x][i] = true;
        }
        return true;
    }

    static private boolean up(int[][] num, int x,int y) {
        for(int i=y; i>y-l;i--) {
            if(i<0||num[x][y]!=num[x][i]||visited[x][i]) {
                return false;
            }
            visited[x][i] = true;
        }
        return true;
    }
}