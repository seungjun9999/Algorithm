import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        list.add(num[0]);
        for (int i = 1; i < n; i++) {
            if(list.get(list.size()-1) < num[i] ){
                list.add(num[i]);
            }else {
                list.set(bs(num[i]),num[i]);
            }
        }
        System.out.println(list.size());
    }

    static int bs(int t){
        int start = 0;
        int end = list.size();
        int result = 0;
        while(start<end){
            int mid = (start + end) /2;
            if(list.get(mid) < t){
                start = mid+1;
            }else{
                end = mid;
                result = mid;
            }
        }
        return result;
    }
}
