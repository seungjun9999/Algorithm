class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        int x=0,y=0;
        int n = (board[0]-1)/2;
        int m = (board[1]-1)/2;
        for(String arr : keyinput) {
            if(arr.equals("up")) {
                if(y!=m) {
                    y++;
                }
            }else if(arr.equals("down")){
                if(y!=-m) {
                    y--;
                }
            }else if(arr.equals("left")) {
                if(x!=-n) {
                    x--;
                }
            }else{
                if(x!=n) {
                    x++;
                }
            }
        }
        return new int[]{x,y};
    }
}