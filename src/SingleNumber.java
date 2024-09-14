import java.util.Arrays;

public class SingleNumber {


    // Without using XOR
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i+=2) {
            if (nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }

    // With using  XOR
    public static int singleNumber1(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }

    public static void main(String[] args) {
        singleNumber1(new int[]{4,2,1,2,1});
    }
}
