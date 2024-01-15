import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
Return a list answer of size 2 where:
answer[0] is a list of all players that have not lost any matches.
answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.
Note:
You should only consider the players that have played at least one match.
The testcases will be generated such that no two matches will have the same outcome.
*/
public class FindPlayersWithZeroOrOneLosses2225 {
    public static void main(String[] args) {
        int[][] matches1 = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(findWinners(matches1));

        int[][] matches2 = {{2, 3}, {1, 3}, {5, 4}, {6, 4}};
        System.out.println(findWinners(matches2));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> playerLosses = new HashMap<>();
        for (int[] match : matches) {
            playerLosses.putIfAbsent(match[0], 0);
            playerLosses.put(match[1], playerLosses.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> notLostPlayers = new ArrayList<>();
        List<Integer> lostOncePlayers = new ArrayList<>();
        for (int player : playerLosses.keySet()) {
            int losses = playerLosses.get(player);
            if (losses == 0) notLostPlayers.add(player);
            else if (losses == 1) lostOncePlayers.add(player);
        }
        List<List<Integer>> answer = new ArrayList<>();
        Collections.sort(notLostPlayers);
        Collections.sort(lostOncePlayers);
        answer.add(notLostPlayers);
        answer.add(lostOncePlayers);
        return answer;

//        Map<Integer, Integer> playerLosses = new HashMap<>();
//        Set<Integer> notLostPlayers = new TreeSet<>();
//        Set<Integer> lostOncePlayers = new TreeSet<>();
//        for (int[] match : matches) {
//            int winner = match[0];
//            int loser = match[1];
//            int losses = playerLosses.getOrDefault(loser, 0) + 1;
//            playerLosses.put(loser, losses);
//            if (losses == 1) {
//                notLostPlayers.remove(loser);
//                lostOncePlayers.add(loser);
//            } else if (losses == 2) lostOncePlayers.remove(loser);
//            if (!playerLosses.containsKey(winner)) {
//                notLostPlayers.add(winner);
//                playerLosses.put(winner, 0);
//            }
//        }
//        List<List<Integer>> answer = new ArrayList<>();
//        answer.add(notLostPlayers.stream().toList());
//        answer.add(lostOncePlayers.stream().toList());
//        return answer;
    }
}
