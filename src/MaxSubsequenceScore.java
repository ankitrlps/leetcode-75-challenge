import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSubsequenceScore {


    record Pair(int a, int b) {}
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(pairs, (x, y) -> y.b - x.b);
        Queue<Integer> que = new PriorityQueue<>(k+1);
        long max = 0;
        long sum = 0;

        for (Pair p : pairs) {
            que.add(p.a);
            sum += p.a;
            if (que.size() > k) sum -= que.poll();
            if (que.size() == k) max = Math.max(max, sum * p.b);
        }
        return max;
    }
    
    public static void main(String[] args) {
        
    }
}
