import java.util.*;

class Solution {
    public int solution(String s) {
        int[] gual = new int[3];
        int result=0;
        // for(int i=0;i<s.length();i++){
        //     char c = s.charAt(i);
        //     if('[' == c){
        //         gual[0]++;
        //     }else if(c==']'){
        //         gual[0]--;
        //     }else if(c=='{'){
        //         gual[1]++;
        //     }else if(c=='}'){
        //         gual[1]--;
        //     }else if(c=='('){
        //         gual[2]++;
        //     }else{
        //         gual[2]--;
        //     }
        // }
        for(int i=0;i<3;i++){
            if(gual[i]!=0){
                System.out.println("여기??");
                return 0;
            }
        }
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            dq = new ArrayDeque<>();
            for(int j=i;j<s.length()+i;j++){
                char c = s.charAt(j%s.length());
                if(c=='[' || c=='{'|| c=='('){
                    dq.push(c);
                }else{
                    if(dq.isEmpty()){
                        result--;
                        break;
                    }else{
                        char a = dq.pop();
                        if(c==']'&& a=='[' ||c=='}'&& a=='{' || c==')'&& a=='(' ){
                            continue;
                        }else{
                            result--;
                            break;
                        }
                    }
                }
            }
            result++;
        }
        if(!dq.isEmpty()){
            return 0;
        }
        return result;
    }
}