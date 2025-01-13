import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> hm = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (String arr : record) {
            String[] cmd = arr.split(" ");
            if (cmd[0].equals("Enter") || cmd[0].equals("Change")) {
                hm.put(cmd[1], cmd[2]);
            }
        }
        for (String arr : record) {
            String[] cmd = arr.split(" ");
            if (cmd[0].equals("Enter")) {
                list.add(hm.get(cmd[1]) + "님이 들어왔습니다.");
            } else if (cmd[0].equals("Leave")) {
                list.add(hm.get(cmd[1]) + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[0]);
    }
}