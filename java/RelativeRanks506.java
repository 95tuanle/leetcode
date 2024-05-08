import java.util.Arrays;
import java.util.HashMap;

/*
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.
*/
public class RelativeRanks506 {
    public static void main(String[] args) {
        int[] score = {5, 4, 3, 2, 1};
        String[] result = findRelativeRanks(score);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    public static String[] findRelativeRanks(int[] score) {
        int length = score.length;
        HashMap<Integer, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < length; i++) scoreMap.put(score[i], i);
        Arrays.sort(score);
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) result[scoreMap.get(score[length - 1 - i])] = "Gold Medal";
            else if (i == 1) result[scoreMap.get(score[length - 1 - i])] = "Silver Medal";
            else if (i == 2) result[scoreMap.get(score[length - 1 - i])] = "Bronze Medal";
            else result[scoreMap.get(score[length - 1 - i])] = String.valueOf(i + 1);
        }
        return result;

//        int n = score.length;
//        int[][] ranks = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            ranks[i][0] = score[i];
//            ranks[i][1] = i;
//        }
//        Arrays.sort(ranks, (a, b) -> b[0] - a[0]);
//        String[] result = new String[n];
//        for (int i = 0; i < n; i++)
//            if (i == 0) result[ranks[i][1]] = "Gold Medal";
//            else if (i == 1) result[ranks[i][1]] = "Silver Medal";
//            else if (i == 2) result[ranks[i][1]] = "Bronze Medal";
//            else result[ranks[i][1]] = String.valueOf(i + 1);
//        return result;
    }
}
