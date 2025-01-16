class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer=1;
        while(Math.abs(b-a)!=1 || ceil(a) != ceil(b)) {
            b = ceil(b);
            a = ceil(a);
            answer++;
        }
        return answer;
    }
    
    int ceil(int x){
        return (int)Math.ceil((double)x/2);
    } 
}