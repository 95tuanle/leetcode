import java.util.LinkedList;

/*
In the world of Dota2, there are two parties: the Radiant and the Dire.
The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.
The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
*/
public class Dota2Senate649 {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("RDD"));
        System.out.println(predictPartyVictory("DDRRR"));
    }

    public static String predictPartyVictory(String senate) {
        LinkedList<Character> queue = new LinkedList<>();
        int radiant = 0;
        int dire = 0;
        for (char senateChar : senate.toCharArray()) {
            queue.offer(senateChar);
            if (senateChar == 'R') radiant++;
            else dire++;
        }
        int bannedRadiant = 0;
        int bannedDire = 0;
        while (radiant > 0 && dire > 0 && !queue.isEmpty()) {
            char senateChar = queue.poll();
            if (senateChar == 'R') {
                if (bannedRadiant > 0) {
                    bannedRadiant--;
                    radiant--;
                } else {
                    bannedDire++;
                    queue.offer(senateChar);
                }
            } else {
                if (bannedDire > 0) {
                    bannedDire--;
                    dire--;
                } else {
                    bannedRadiant++;
                    queue.offer(senateChar);
                }
            }
        }
        return radiant > 0 ? "Radiant" : "Dire";
    }
}
