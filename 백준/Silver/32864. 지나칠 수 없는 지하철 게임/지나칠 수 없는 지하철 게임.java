import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] lines = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lines[i] = Integer.parseInt(st.nextToken());
        }
        
        int whoWin = 0; // 0 세훈 1 민아
        
        for (int i = n - 2; i >= 0; i--) {
            if (lines[i] == 0) {
              
            } else if (lines[i] == 1) { 
                if (i == 1) {
                    if (whoWin == 1) 
                        whoWin = 0;
                    else 
                        whoWin = 1;
                    i--;
                } else if (lines[i - 1] == 0) {
                    if (whoWin == 1) 
                        whoWin = 1;
                    else 
                        whoWin = 0;
                    i--;
                } else if (lines[i - 1] == 1) { 
                    if (whoWin == 1) 
                        whoWin = 1;
                    else 
                        whoWin = 0;
                    i--;
                }
            }
        }
        
        if (whoWin == 0) {
            System.out.println("mnx");
        } else {
            System.out.println("alsdkffhgk");
        }
    }
}