/**
 * https://leetcode.com/problems/can-place-flowers/description/
 */

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = flowerbed[0];
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (prev == 0 && ((i + 1 < flowerbed.length && flowerbed[i+1] == 0) || i+1 == flowerbed.length)) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            prev = flowerbed[i];
        }
        return n <= 0;
    }
    
    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,1}, 1);
        canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,1}, 2);
    }
}
