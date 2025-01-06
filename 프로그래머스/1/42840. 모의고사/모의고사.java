import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {3,3,1,1,2,2,4,4,5,5};
        ArrayList<Integer>list = new ArrayList<>(); 
        int result1=0,result2=0,result3=0;
        for(int i=0;i<3;i++){
            int cnt1=1;
            if(i==0){
                for(int j=0;j<answers.length;j++){
                    if(cnt1 == answers[j]){
                        result1++;
                    }
                    cnt1++;
                    if(cnt1>5){
                        cnt1=1;
                    }
                }
                list.add(1);
            }else if(i==1){
                for(int j=0;j<answers.length;j++){
                    if(j%2==0){
                        if(answers[j]==2)
                        result2++;
                        System.out.println(j);
                    }else{
                        if(answers[j]==cnt1){
                            result2++;
                            System.out.println(cnt1);
                        }  
                        cnt1++;
                        if(cnt1==2){
                            cnt1++;
                        }
                        if(cnt1>5){
                            cnt1=1;
                        }
                    }
                    
                }
                System.out.println(result2);
                if(result1<result2){
                    result1=result2;
                    list.remove(0);
                    list.add(2);
                }else if(result1==result2){
                    list.add(2);
                }
            }else{
                cnt1=0;
                for(int j=0;j<answers.length;j++){
                    if(answer[cnt1] == answers[j]){
                        result3++;
                    }
                    cnt1++;
                    if(cnt1==10){
                        cnt1=0;
                    }
                }
                if(result1<result3){
                    list.clear();
                    list.add(3);
                }else if(result1==result3){
                    list.add(3);
                }
                
            }
        } 
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}