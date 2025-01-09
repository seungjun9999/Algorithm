import java.util.*;

class Solution {
    
    static class Node{
        int price, total;
        
        Node(int price,int total){
            this.price = price;
            this.total = total;
        }
    }
    
    public int[] solution(int[] prices) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        
        int n = prices.length;
        int[] answer = new int[n];
        
        dq.push(new Node(prices[n - 1], 0));
        answer[n - 1] = 0;
        
        for (int i = n - 2; i >= 0; i--) {
            while (!dq.isEmpty()) {
                if (prices[i] > dq.peek().price) {
                    dq.push(new Node(prices[i],answer[i]+=1));
                    break;
                } else {
                    Node recent = dq.pop();
                    answer[i] += recent.total;
                    if (dq.isEmpty()) {
                        dq.push(new Node(prices[i],answer[i]+=1));
                        break;
                    }
                }
            }
        }

        return answer;
    }
}