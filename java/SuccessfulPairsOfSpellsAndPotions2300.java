import java.util.Arrays;

/*
You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
*/
public class SuccessfulPairsOfSpellsAndPotions2300 {
    public static void main(String[] args) {
        int[] spells = {1, 2, 3, 4, 5};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 10;
        int[] pairs = successfulPairs(spells, potions, success);
        for (int pair : pairs) System.out.print(pair + " ");
        System.out.println();

        spells = new int[]{1, 2, 3, 4, 5};
        potions = new int[]{1, 2, 3, 4, 5};
        success = 1;
        pairs = successfulPairs(spells, potions, success);
        for (int pair : pairs) System.out.print(pair + " ");
        System.out.println();

        spells = new int[]{1, 2, 3, 4, 5};
        potions = new int[]{1, 2, 3, 4, 5};
        success = 100;
        pairs = successfulPairs(spells, potions, success);
        for (int pair : pairs) System.out.print(pair + " ");
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            if ((long) spell * potions[m - 1] >= success) {
                double target = (double) success / spell;
                int left = 0, right = m - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (potions[mid] >= target) right = mid - 1;
                    else left = mid + 1;
                }
                spells[i] = m - left;
            } else spells[i] = 0;
        }
        return spells;
    }

}
