import java.util.*;

class Solution {
    class Node {
        String name;
        int pay;
        
        Node(String name ,int pay) {
            this.name = name;
            this.pay = pay;
        }
    }
    static HashMap<String,Node> upper = new HashMap<>();
    static ArrayList<Integer> answer = new ArrayList<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        for(int i=0;i<enroll.length;i++) {
            upper.put(enroll[i],new Node(referral[i],0));
        }
        
        for(int i=0;i<seller.length;i++) {
            String arr=seller[i];
            amount[i]*=100;
            dadan(arr,amount[i]);
        }
        for(String me : enroll) {
            answer.add(upper.get(me).pay);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    void dadan(String arr,int mon) {
        if(!upper.containsKey(arr)) return;
        if(mon<10){
            upper.get(arr).pay+=mon;
            return;
        }   
        upper.get(arr).pay += mon - (mon/10);
        dadan(upper.get(arr).name,mon/10);
    }
}