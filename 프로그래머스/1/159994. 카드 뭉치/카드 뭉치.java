import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> card1 = new ArrayDeque<>();
        ArrayDeque<String> card2 = new ArrayDeque<>();
        
        for(int i=0; i<cards1.length; i++) {
            card1.offer(cards1[i]);
        }
        for(int i=0; i<cards2.length; i++) {
            card2.offer(cards2[i]);
        }
        for(int i=0;i<goal.length;i++) {
            if(!card1.isEmpty() && card1.peek().equals(goal[i])) {
                card1.poll();
            } else if(!card2.isEmpty() && card2.peek().equals(goal[i])) {
                card2.poll();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}