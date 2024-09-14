/*
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
 */

import java.util.ArrayList;
import java.util.List;

public class KidsGreatestCandies1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int kids = candies.length;
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;
        for (int k = 0; k < kids; k++) {
            if (candies[k] > maxCandies) maxCandies = candies[k];
        }

        for (int i = 0; i < kids; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        KidsGreatestCandies1431 candies1431 = new KidsGreatestCandies1431();
        System.out.println(candies1431.kidsWithCandies(new int[]{2,3,5,1,3}, 3));
        System.out.println(candies1431.kidsWithCandies(new int[]{4,2,1,1,2}, 1));
        System.out.println(candies1431.kidsWithCandies(new int[]{12,1,12}, 10));
    }
}
