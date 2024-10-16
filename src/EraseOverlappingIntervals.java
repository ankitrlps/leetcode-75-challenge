import java.util.Arrays;

public class EraseOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int min = 0;
        int i = 1;
        while (i < intervals.length) {
            if (end <= intervals[i][0]) {
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (end > intervals[i][1]) {
                start = intervals[i][0];
                end = intervals[i][1];
                min++;
            } else {
                min++;
            }
            i++;
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
