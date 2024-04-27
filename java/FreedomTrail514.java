import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring" and use the dial to spell a specific keyword to open the door.
Given a string ring that represents the code engraved on the outer ring and another string key that represents the keyword that needs to be spelled, return the minimum number of steps to spell all the characters in the keyword.
Initially, the first character of the ring is aligned at the "12:00" direction. You should spell all the characters in key one by one by rotating ring clockwise or anticlockwise to make each character of the string key aligned at the "12:00" direction and then by pressing the center button.
At the stage of rotating the ring to spell the key character key[i]:
You can rotate the ring clockwise or anticlockwise by one place, which counts as one step. The final purpose of the rotation is to align one of ring's characters at the "12:00" direction, where this character must equal key[i].
If the character key[i] has been aligned at the "12:00" direction, press the center button to spell, which also counts as one step. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.
*/
public class FreedomTrail514 {
    public static void main(String[] args) {
        System.out.println(findRotateSteps("godding", "gd")); // 4
        System.out.println(findRotateSteps("godding", "godding")); // 13
    }

    public static int findRotateSteps(String ring, String key) {
        int ringLength = ring.length();
        int[] dp = new int[ringLength];
        HashMap<Character, ArrayList<Integer>> positions = new HashMap<>();
        for (int i = 0; i < ringLength; i++)
            positions.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        for (int i = key.length() - 1; i >= 0; i--) {
            int[] current = new int[ringLength];
            Arrays.fill(current, Integer.MAX_VALUE);
            for (int position : positions.get(key.charAt(i)))
                for (int j = 0; j < ringLength; j++) {
                    int stepsBetween = Math.abs(j - position);
                    current[j] = Math.min(current[j], dp[position] + 1 + Math.min(stepsBetween, ringLength - stepsBetween));
                }
            dp = current;
        }
        return dp[0];

//        int ringLength = ring.length();
//        int[] dp = new int[ringLength];
//        for (int i = key.length() - 1; i >= 0; i--) {
//            int[] current = new int[ringLength];
//            Arrays.fill(current, Integer.MAX_VALUE);
//            char character = key.charAt(i);
//            for (int j = 0; j < ringLength; j++) {
//                for (int k = 0; k < ringLength; k++) {
//                    if (ring.charAt(k) == character) {
//                        int stepsBetween = Math.abs(k - j);
//                        current[j] = Math.min(current[j], dp[k] + 1 + Math.min(stepsBetween, ringLength - stepsBetween));
//                    }
//                }
//            }
//            dp = current;
//        }
//        return dp[0];
    }
}
