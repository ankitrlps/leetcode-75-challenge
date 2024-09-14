public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int rightMul = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] = res[i] * rightMul;
            rightMul *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }

    public int[] productExceptSelf1(int[] nums) {
        int totalMul = 1;
        int zeroes = 0;
        for (int i : nums) {
            if (i != 0) {
                totalMul *= i;
            } else {
                zeroes++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
             if (zeroes == 1 && nums[i] == 0) {
                nums[i] = totalMul;
            } else if (zeroes >= 1) {
                nums[i] = 0;
            } else {
                nums[i] = totalMul / nums[i];
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        
    }
}
