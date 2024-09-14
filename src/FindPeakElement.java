public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int n = nums.length;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        int left = 1;
        int right = n - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public int findPeakElement1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{3,4,3,2,1}));
        System.out.println(findPeakElement(new int[]{6,1,2,3,7}));
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
