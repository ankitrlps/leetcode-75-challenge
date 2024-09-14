import java.util.PriorityQueue;

public class TotalCostHireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        if (costs.length == 1) return costs[0];
        long totCost = 0;
        PriorityQueue<Integer> first = new PriorityQueue<>();
        PriorityQueue<Integer> last = new PriorityQueue<>();
        int i = 0;
        int j = costs.length - 1;
        int m = 1;
        while (m <= candidates && i < j) {
            first.add(costs[i]);
            last.add(costs[j]);
            i++;
            j--;
            m++;
        }
        for (int a = 1; a <= k; a++) {
            if (first.size() == 0) {
                totCost += last.poll();
                continue;
            }
            if (last.size() == 0) {
                totCost += first.poll();
                continue;
            }
            if (first.peek() <= last.peek()) {
                totCost += first.poll();
                if (i <= j) {
                    first.add(costs[i]);
                    i++;
                }
            } else {
                if (last.size() > 0) {
                    totCost += last.poll();
                    if (j >= i) {
                        last.add(costs[j]);
                        j--;
                    }
                }
            }
        }

        return totCost;
    }

    public static void main(String[] args) {
        
    }
    
}
