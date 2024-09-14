import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static int subarraySum(int[] nums, int k) {
        long currSum = 0;
        int total = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            long diff = currSum - k;
            total += map.getOrDefault(diff, 0);
            map.put(currSum, 1 + map.getOrDefault(currSum, 0));
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
    }
}
