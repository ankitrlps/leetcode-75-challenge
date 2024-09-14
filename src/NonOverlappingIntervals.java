import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonOverlappingIntervals {
    
    public static void main(String[] args) {
        
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int min = 0;
        // can't have two same start numbers
        // can't have an interval falling between other bigger interval
        // start of an interval needs to be greater than the end of a previous interval
        Arrays.sort(intervals, (start,end) -> Integer.compare(start[0], end[0]));
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                min++;
                end = Math.min(intervals[i][1], end);
            }
        }

        return min;
    }

    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < intervals.length; i ++) {
            Integer v = map.get(intervals[i][0]);
            if (v == null) {
                map.put(intervals[i][0], intervals[i][1]);
            } else {
                v = v < intervals[i][1] ? v : intervals[i][1];
                map.put(intervals[i][0], v);
                res ++;
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int start = list.get(0);
        int end = map.get(start);
        for (int i = 1; i < list.size(); i ++) {
            int x = list.get(i);
            int y = map.get(x);
            if (x < end) {
                end = end < y ? end : y;
                res ++;
            } else {
                end = y;
            }
        }

        return res;
    }
}
