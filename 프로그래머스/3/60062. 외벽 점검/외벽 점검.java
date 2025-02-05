import java.util.*;

class Solution {
    static int n, stIdx, edIdx, maax = 0, miin = 10, flag = 0;
    static int[] weak, dist;
    static boolean[] visited;
    static ArrayDeque<Integer> que;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static ArrayDeque<Integer> temp = new ArrayDeque<>();
    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        
        visited = new boolean[dist.length];
        
        //init();
        for(int i=0;i<weak.length;i++){
            temp.offer(weak[i]);
        }
        for(int i=0;i<weak.length;i++){
            que = new ArrayDeque<>(temp);
            backt(0);
            if(!temp.isEmpty()) {
                temp.offer(temp.poll());
            }
            
        }
        
        
        return miin == 10 ? -1 : miin ;
    }
    
    private void init() {
        int len = weak.length;
        
       for(int i=0; i < len; i++) {
           if(i+1 < len && maax < weak[i+1] - weak[i]) {
               maax = weak[i+1] - weak[i];
               stIdx = i+1;
               edIdx = i;
           } else if(i == len-1 && maax < n-weak[len-1] + weak[0]) {
               maax = n - weak[len-1] + weak[0];
               stIdx = 0;
               edIdx = len-1;
           }         
       }
        
        for(int i = stIdx ; i < len+stIdx; i++) {
            que.offer(weak[i%len]);
        }
    }
    
    private void backt(int cnt) {
        if(flag==1) {
            return;
        }
        if(que.isEmpty()) {
            miin = Math.min(miin,cnt);
            if(miin == 1) {
                flag=1;
            }
            return;
        }
        if(cnt == dist.length) {
            return;
        }
        
        for(int i=0;i<dist.length;i++) {
            if(!visited[i]) {
                visited[i] = true;
                int first = 0;
                if(!que.isEmpty()) {
                    first = que.peek();
                }                    
                outQue(dist[i],first);
                backt(cnt + 1);
                addQue(first);
                visited[i] = false;
            }
        }
    }
    
    private void outQue(int s, int f) {
        if(f >= n) {
            while(!que.isEmpty()) {
                stack.push(que.poll());
            }
            return;
        }
        if(f+s >= n) {
            while(!que.isEmpty() && ((que.peek()>=f && que.peek() < n) || que.peek() <= (f+s) % n)){
                stack.push(que.poll());
            }
        }else {
            while(!que.isEmpty() && (f + s >= que.peek() && f <= que.peek())) {
                stack.push(que.poll());
            }
        }        
    }
    private void addQue(int f) {
        while(!stack.isEmpty()) {
            if(stack.peek() == f) {
                que.addFirst(stack.pop());
                break;
            }
            que.addFirst(stack.pop());
        }
    }
}