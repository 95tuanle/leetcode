import java.util.Arrays;

/*
You start with an initial power of power, an initial score of 0, and a bag of tokens given as an integer array tokens, where each tokens[i] donates the value of tokeni.
Your goal is to maximize the total score by strategically playing these tokens. In one move, you can play an unplayed token in one of the two ways (but not both for the same token):

Face-up: If your current power is at least tokens[i], you may play tokeni, losing tokens[i] power and gaining 1 score.
Face-down: If your current score is at least 1, you may play tokeni, gaining tokens[i] power and losing 1 score.
Return the maximum possible score you can achieve after playing any number of tokens.
*/
public class BagOfTokens948 {
    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{100}, 50));
        System.out.println(bagOfTokensScore(new int[]{200, 100}, 150));
        System.out.println(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, left = 0, right = tokens.length - 1;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
            } else if (score >= 1 && left != right) {
                power += tokens[right];
                score--;
                right--;
            } else break;
        }
        return score;
    }
}
