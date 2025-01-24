import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
        String[] lastlen = video_len.split(":");
        String[] poslen = pos.split(":");
        String[] opstartlen = op_start.split(":");
        String[] opendlen = op_end.split(":");
        int lastTime = Integer.parseInt(lastlen[0])*60 + Integer.parseInt(lastlen[1]);
        int nowTime = Integer.parseInt(poslen[0])*60 + Integer.parseInt(poslen[1]);
        int opStart = Integer.parseInt(opstartlen[0])*60 + Integer.parseInt(opstartlen[1]);
        int opEnd = Integer.parseInt(opendlen[0])*60 + Integer.parseInt(opendlen[1]);
        if(nowTime >= opStart && nowTime <= opEnd) {
                nowTime = opEnd;
        }
        for (String command : commands) {
            if(nowTime >= opStart && nowTime <= opEnd) {
                nowTime = opEnd;
            }
            if(command.equals("next")) {
                nowTime += 10;
                if(nowTime > lastTime) {
                    nowTime = lastTime;
                } 
            } else{
                nowTime -= 10;
                if(nowTime<0) {
                    nowTime = 0;
                }
            }
            if(nowTime >= opStart && nowTime <= opEnd) {
                nowTime = opEnd;
            }
        }
        String first = String.valueOf(nowTime/60);
        String last = String.valueOf(nowTime%60);
        if(first.length() == 1) {
            first ="0"+first;
        }
        if(last.length() == 1) {
            last = "0"+last;
        }
        sb.append(first).append(":").append(last);
        System.out.println(lastTime);
        return sb.toString();
    }
}