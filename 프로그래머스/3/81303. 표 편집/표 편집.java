import java.util.*;
import java.io.*;

class Solution {
    static class Node {
        int idx;
        Node up;
        Node down;
        
        Node(int idx) {
            this.idx = idx;
        }
    }
    
    static StringBuilder sb = new StringBuilder();
    static ArrayList <Node> list = new ArrayList<>();
    static ArrayDeque <Integer> dq = new ArrayDeque<>();
    static int[] num;
    
    public String solution(int n, int k, String[] cmd) {
        num = new int[n];
        // 표 데이터 입력
        list.add(new Node(0));
        
        for(int i = 1;i < n;i++){
            list.add(new Node(i));
            list.get(i).up = list.get(i-1);
            list.get(i-1).down = list.get(i);
        }
        
        for(int i = 0; i < cmd.length; i++){
            String[] order = cmd[i].split(" ");
            if(order[0].equals("U")) {
                int a = Integer.parseInt(order[1]);
                while(a --> 0) {
                    k = list.get(k).up.idx;
                }
            } else if(order[0].equals("D")) {
                int a = Integer.parseInt(order[1]);
                while(a --> 0) {
                    k = list.get(k).down.idx;
                }
            } else if(order[0].equals("C")) {
                Node cur = list.get(k);
                dq.push(cur.idx);
                num[k] = 1;
                
                if(cur.up != null && cur.down != null) {
                    cur.up.down = cur.down;
                    cur.down.up = cur.up;
                } else if(cur.down == null) {
                    cur.up.down = null;
                } else {
                    cur.down.up = null;
                }
                
                if(cur.down==null) {
                    k = cur.up.idx;
                } else {
                    k = cur.down.idx;
                }
            } else {
                int a = dq.pop();
                num[a] = 0;
                Node cur = list.get(a);
                if(cur.up != null) {
                    cur.up.down = cur;
                }
                if(cur.down != null) {
                    cur.down.up = cur;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(num[i]==1){
                sb.append("X");
            }else{
                sb.append("O");
            }
        }
        return sb.toString();
    }
}