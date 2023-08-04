/*
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
*/

public class CanPlaceFlowers605 {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{0, 1, 0}, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int planted = 0;
        if (flowerbed.length > 1) {
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1) continue;
                if ((i == 0 && flowerbed[i + 1] == 0) || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) || (i != 0 && i != flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)) {
                    planted++;
                    if (planted >= n) return true;
                    flowerbed[i] = 1;
                }
            }
        } else {
            if (flowerbed[0] == 0) planted++;
        }
        return planted >= n;
    }
}
