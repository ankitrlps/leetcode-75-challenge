import java.util.PriorityQueue;

public class KthLargestElementArray {

    public int findKthLargest(int[] nums, int k) {
        // Array.sort(nums);
        // return nums[nums.length-k];       

        k = nums.length-k;
        return quickSelect(nums, 0, nums.length-1, k);
    }

    private int usingPq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            pq.add(i);
        }
        int res = 0;

        while (k > 0) {
            res = pq.poll();
            k--;
        }
        return res;
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right];
        int pointer = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                int temp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = temp;
                pointer++;
            }
        }
        int temp = nums[pointer];
        nums[pointer] = pivot;
        nums[right] = temp;
        
        if (pointer < k) {
            return quickSelect(nums, pointer + 1, right, k);
        } else if (pointer > k) { 
            return quickSelect(nums, left, pointer - 1, k);
        } else {
            return nums[k];
        }
    }
    
    public static void main(String[] args) {
    }
}
