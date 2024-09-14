import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotion {

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        int pLen = potions.length;
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int ii = binarySearch(potions, 0, pLen-1, spells[i], success);
            if (ii == -1) continue;
            pairs[i] = ii == 0 ? pLen : pLen - ii;
        }
        return pairs;
    }

    private static int binarySearch(int[] arr, int left, int right, long spell, long success) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid: " + spell + " " + left + " " + mid + " " + right);
            long prod = (long) arr[mid] * spell;
            if (prod >= success) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
            if (left>right) return left;
            return binarySearch(arr, left, right, spell, success);
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.asList(successfulPairs(new int[]{15,8,19}, new int[]{38,36,23}, 328)));
    }
}
