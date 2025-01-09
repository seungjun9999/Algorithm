import java.util.*;

class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> dq = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(dq.isEmpty() || dq.peek() != c) {
                dq.push(c);
            } else {
                dq.pop();
            }
        }

        return dq.isEmpty()? 1: 0;
    }
}