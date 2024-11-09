import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        int result = 0, cnt = 0;

        for (int i = 1; i < m - 1; i++) {
            if (c[i - 1] == 'I' && c[i] == 'O' && c[i + 1] == 'I') {
                cnt++;
                if(cnt==n){
                    cnt--;
                    result++;
                }
                i+=1;
            }else{
                cnt=0;
            }
        }
        System.out.println(result);
    }
}