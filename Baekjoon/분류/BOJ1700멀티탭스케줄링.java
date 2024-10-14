import java.io.*;
import java.util.*;

public class BOJ1700멀티탭스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int result = 0;
        int[] loc = new int[k];
        boolean[] con = new boolean[k + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            loc[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            if (!con[loc[i]]) {
                if (cnt != n) {
                    cnt++;
                    con[loc[i]] = true;
                } else {
                    stack = new Stack<>();
                    for (int j = i + 1; j < k; j++) {
                        if (con[loc[j]] && !stack.contains(loc[j])) {
                            stack.push(loc[j]);
                        }
                    }

                    if (stack.size() != n) {
                        for (int j = 0; j < 101; j++) {
                            if (con[j] && !stack.contains(j)) {
                                con[j] = false;
                                con[loc[i]] = true;
                                break;
                            }
                        }
                    } else {
                        con[stack.pop()] = false;
                        con[loc[i]] = true;
                    }
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}