public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int maxOnes = 0;
        int zeros = 0;
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[j] == 0) {
                    zeros = zeros - 1;
                }
                j = j + 1;
            }
            maxOnes = Math.max(maxOnes, i - j + 1);
            i++;
        }
        return maxOnes;
    }
    
    public static void main(String[] args) {
        System.out.println(11/4);
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
