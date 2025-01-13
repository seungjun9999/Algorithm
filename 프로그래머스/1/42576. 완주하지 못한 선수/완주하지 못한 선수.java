import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<participant.length;i++){
            if(hm.containsKey(participant[i])){
                hm.put(participant[i],hm.get(participant[i])+1);
            } else {
                hm.put(participant[i],1);
            }
        }
        for(String arr : completion) {
            hm.put(arr,hm.get(arr)-1);
        }
        for(int i =0; i<participant.length;i++) {
            if(hm.get(participant[i])>0){
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}