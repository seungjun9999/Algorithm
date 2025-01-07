import java.util.*;
import java.io.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int idx;
        double fail;

        Node(int idx,double fail){
            this.idx = idx;
            this.fail = fail;
        }
        
        @Override
        public int compareTo(Node o){
            if(this.fail == o.fail){
                return this.idx - o.idx;
            }
            return Double.compare(o.fail,this.fail);
        }
    }
    
    public int[] solution(int N, int[] stages) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] num = new int[N+2];
        int[] answer = new int[N];
        int people = stages.length;
        
        for(int i=0;i<stages.length;i++){
            num[stages[i]]++;
        }
        for(int i=1;i<=N;i++){
            if(num[i]==0){
                pq.offer(new Node(i,0.0));
            }else{
                pq.offer(new Node(i,num[i]/(double)people));
            }
            
            
            people-=num[i];
        }
        int cnt=0;
        while(!pq.isEmpty()){
            answer[cnt] = pq.poll().idx;
            cnt++;
        }
        return answer;
    }
}