import java.util.*;

class Solution {
    class Node{
        int pro,spd;
        
        Node(int pro,int spd){
            this.pro = pro;
            this.spd = spd;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        ArrayDeque<Integer> num = new ArrayDeque<>();
        for(int i = 0; i < progresses.length;i++){
            dq.offer(new Node(progresses[i],speeds[i]));
        }
        while(!dq.isEmpty()) {
            int cnt=1;
            Node recent = dq.poll();
            int d = (int) Math.ceil((100-recent.pro) / (double) recent.spd);
            while(!dq.isEmpty()) {
                Node now =  dq.peek();
                if(now.pro + now.spd*d >= 100){
                    dq.poll();
                    cnt++;
                }else {
                    break;
                }
            }
            num.offer(cnt);
        }
        int[] answer = new int[num.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = num.poll();
        }
        return answer;
    }
}