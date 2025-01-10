import java.util.*;
import java.io.*;

class Solution {
    
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque <Integer> dq = new ArrayDeque<>();
    
    public String solution(int n, int k, String[] cmd) {   
        int size = n;
        for(int i = 0; i < cmd.length; i++){
            String[] order = cmd[i].split(" ");
            if(order[0].equals("U")) {
                k-=Integer.parseInt(order[1]);
            } else if(order[0].equals("D")) {
                k+=Integer.parseInt(order[1]);
            } else if(order[0].equals("C")) {
                dq.push(k);
                if(k==size-1) {
                    k--;
                }
                size--;
            } else {
                if(k>=dq.pop()) {
                    k++;
                }
                size++;
            }
        }
        for(int i=0;i<size;i++){
            sb.append("O");
        }
        while(!dq.isEmpty()){
            sb.insert(dq.pop(),"X");
        }
        return sb.toString();
    }
}