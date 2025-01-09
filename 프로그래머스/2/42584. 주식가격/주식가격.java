import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ArrayDeque<Integer> num = new ArrayDeque<>();
        int n = prices.length;
        int[] answer = new int[n];
        dq.push(prices[n-1]);
        num.push(0);
        answer[n-1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            int cnt = i;
            while(!dq.isEmpty()){
                if(prices[i] > dq.peek()){
                    dq.push(prices[i]);
                    answer[i]+=1;
                    num.push(answer[i]);
                    break;
                } else {
                    dq.pop();
                    answer[i] += num.pop();
                    if(dq.isEmpty()){
                        dq.push(prices[i]);
                        answer[i] +=1;
                        num.push(answer[i]);
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}