import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        Queue<Integer> rads = new LinkedList<>();
        Queue<Integer> dirs = new LinkedList<>();
        int len = senate.length();
        for (int i = 0; i < len; i++) {
            if (senate.charAt(i) == 'R') {
                rads.add(i);
            } else {
                dirs.add(i);
            }
        }

        // comparing the indexes, smaller index beats the bigger index 
        // and won index adds another element in que with len increment
        while (!rads.isEmpty() && !dirs.isEmpty()) {
            int r = rads.poll();
            int d = dirs.poll();
            if (r < d) {
                rads.add(len++);
            } else {
                dirs.add(len++);
            }
        }

        return rads.isEmpty() ? "Dire" : "Radiant";
    }
    
    public static void main(String[] args) {
        
    }
}
