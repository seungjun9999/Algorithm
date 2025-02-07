import java.util.*;
import java.io.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb= new StringBuilder();
        String[] answer = Long.toString(n).split("");
        Arrays.sort(answer,Collections.reverseOrder());
        for(String s : answer) {
            sb.append(s);
        }
        return Long.parseLong(sb.toString());
    }
}