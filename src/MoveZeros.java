public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int zIndex = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                while (nums[zIndex] != 0 && zIndex < i)  {
                    zIndex++;
                }
                int temp = nums[i];
                nums[i] = nums[zIndex];
                nums[zIndex] = temp;
            }
            i++;
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums.length == 1)
            return;
        int z = 0;
        int nz = 1;
        while (z < nz && nz < nums.length) {
            if (nums[z] == 0 && nums[nz] != 0) { // found a zero and non-zero values, swapping elements
                nums[z] = nums[nz];
                nums[nz] = 0;
            }
            while (z < nz) { // find the next zero
                if (nums[z] == 0) {
                    break;
                }
                z++;
            }
            nz++;
        }
    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(new int[]{0,1,0,3,12});
        moveZeros.moveZeroes(new int[]{0});
    }
}
