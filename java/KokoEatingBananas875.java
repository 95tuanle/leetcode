/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
*/
public class KokoEatingBananas875 {
    public static void main(String[] args) {
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println(minEatingSpeed(piles1, h1));

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println(minEatingSpeed(piles2, h2));

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println(minEatingSpeed(piles3, h3));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) max = Math.max(pile, max);
        if (piles.length == h) return max;
        int result = max, min = 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int hour = 0;
            for (int pile : piles) hour += Math.ceil((double) pile / mid);
            if (hour > h) min = mid + 1;
            else {
                result = Math.min(mid, result);
                max = mid - 1;
            }
        }
        return result;
    }
}
