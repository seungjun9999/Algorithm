import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String arr = br.readLine();
        ArrayDeque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length(); i++) {
            char c = arr.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                dq.push('(');
            } else if (c == ')') {
                while (!dq.isEmpty() && dq.peek() != '(') {
                    sb.append(dq.pop());
                }
                dq.pop();
            } else {
                while (!dq.isEmpty() && isNum(dq.peek()) >= isNum(c)) {
                    if (dq.peek() == '(') break;
                    sb.append(dq.pop());
                }
                dq.push(c);
            }
        }
        while (!dq.isEmpty()) {
            sb.append(dq.pop());
        }
        System.out.println(sb);
    }

    static private int isNum(char c) {
        if (c == '(') return 0;
        if (c == '+' || c == '-') return 1;
        else return 2;
    }
}