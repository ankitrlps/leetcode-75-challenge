public class MaximumAverageSubArray {

    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i+1 <= k) {
                sum += nums[i];
                if (i+1 == k) {
                    max = sum / k;
                }
            } else {
                sum = sum - nums[i-k] + nums[i];
                max = Math.max(max, sum/k);
            }
        }
        return max;
    }

    public static void main(String[] args) {
           
    }
}
