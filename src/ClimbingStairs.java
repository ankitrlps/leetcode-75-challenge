public class ClimbingStairs {

    /* https://leetcode.com/problems/min-cost-climbing-stairs/description/ */

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1)
            return cost[0];
        for (int i = cost.length - 2; i >= 0; i--) {
            cost[i] = Math.min(cost[i] + cost[i + 1], cost[i] + (i + 2 == cost.length ? 0 : cost[i + 2]));
        }
        return Math.min(cost[0], cost[1]);
    }

    public static void main(String[] args) {

    }
}
