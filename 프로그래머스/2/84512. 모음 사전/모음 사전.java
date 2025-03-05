import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static char[] c = {'A','E','I','O','U'};
    static String word;
    static int answer=0,flag=0;
    public int solution(String word) {
        this.word = word;
        dfs("",0);
        return answer;
    }
    static private void dfs(String now,int cnt) {
        if(flag==1||now.equals(word)){
            answer = list.size();
            flag=1;
            return;
        }
        list.add(now);
        if(cnt==5) {
            return;
        }
        for(int i=0;i<5;i++) {
            dfs(now+c[i],cnt+1);
        }
    } 
}