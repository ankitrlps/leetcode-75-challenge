public class LongestSubarrayOfOnesDeleteOneElement {

    public static int longestSubarray(int[] nums) {
        int zeros = 0;
        int max = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                zeros += 1;
            }

            while (zeros > 1) {
                if (nums[i] == 0) {
                    zeros--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max-1;
    }
    
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
        System.out.println(longestSubarray(new int[]{1,1,1}));
    }
}
