/*
We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
You call a pre-defined API int guess(int num), which returns three possible results:
-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e., num == pick).
Return the number that I picked.
*/
public class GuessNumberHigherOrLower374 {
    public static void main(String[] args) {
        Solution solution = new Solution(6);
        System.out.println(solution.guessNumber(10));

        Solution solution2 = new Solution(1);
        System.out.println(solution2.guessNumber(1));

        Solution solution3 = new Solution(1);
        System.out.println(solution3.guessNumber(2));
    }
}

class Solution extends GuessGame {
    public Solution(int pick) {
        super(pick);
    }

    public int guessNumber(int n) {
        int lower = 1, upper = n;
        int num, result;
        do {
            num = lower + (upper - lower) / 2;
            result = guess(num);
            if (result == -1) upper = num;
            else if (result == 1) lower = num + 1;
        } while (result != 0);
        return num;
    }
}

class GuessGame {
    int pick;

    public GuessGame(int pick) {
        this.pick = pick;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     * int guess(int num);
     */
    public int guess(int num) {
        if (num == pick) return 0;
        return num < pick ? 1 : -1;
    }
}