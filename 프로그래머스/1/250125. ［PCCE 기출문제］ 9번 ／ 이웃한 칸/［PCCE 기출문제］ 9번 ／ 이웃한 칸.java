class Solution {
    static String[][] board;
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        this.board = board;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int i=0;i<4;i++) {
            int x = dx[i] + h;
            int y = dy[i] + w;
            if(check(x,y) && board[h][w].equals(board[x][y])) {
                answer++;
            }
        }
        return answer;
    }
    private boolean check(int x,int y) {
        return x>=0 && x<board.length && y>=0 && y<board[0].length;
    }
}