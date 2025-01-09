import java.util.*;

class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for(int i=0;i<s.length();i++) {
            if(dq.isEmpty() || dq.peek() != s.charAt(i)){
                dq.push(s.charAt(i));
            }else {
                dq.pop();
            }
        }
        if(dq.isEmpty()){
            return 1;
        }
        return 0;
    }
}