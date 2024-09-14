public class IncreasingTripletSubSequence {

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3 || nums == null)
            return false;
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;

        for (int x : nums) {
            if (x <= i) {
                i = x;
            } else if (x > i && x <= j) {
                j = x;
            } else {
                if (i < j)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] { 20, 100, 10, 12, 5, 13 }));
        System.out.println(increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));
        System.out.println(increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
    }

}