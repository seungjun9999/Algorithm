import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hm = new HashSet<>();
        HashSet<Character> hj = new HashSet<>();
        char[] mo = {'a', 'i', 'y', 'e', 'o', 'u'};
        char[] ja = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'};
        for (char m : mo) {
            hm.add(m);
        }
        for (char j : ja) {
            hj.add(j);
        }
        String arr;
        while ((arr = br.readLine()) != null) {
            for (char c : arr.toCharArray()) {
                int flag = 0;
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                    flag = 1;
                }
                if (hm.contains(c)) {
                    for (int i = 0; i < 6; i++) {
                        if (mo[i] == c) {
                            i = (i + 6 - 3) % 6;
                            c = mo[i];
                            break;
                        }
                    }
                } else if (hj.contains(c)) {
                    for (int i = 0; i < 20; i++) {
                        if (ja[i] == c) {
                            i = (i + 20 - 10) % 20;
                            c = ja[i];
                            break;
                        }
                    }
                }
                if (flag == 1) {
                    c = Character.toUpperCase(c);
                }
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}