import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            dq.push(s.charAt(i));
        }
        while (!dq.isEmpty()) {
            char c = dq.pop();
            if (c == ')') {
                cnt += 1;
            } else {
                cnt -= 1;
            }
            if (cnt < 0) {
                return false;
            }
        }
        if (cnt != 0) {
            return false;
        }

        return true;
    }
}