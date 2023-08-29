/*
You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':
if the ith character is 'Y', it means that customers come at the ith hour
whereas 'N' indicates that no customers come at the ith hour.
If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
For every hour when the shop is open and no customers come, the penalty increases by 1.
For every hour when the shop is closed and customers come, the penalty increases by 1.
Return the earliest hour at which the shop must be closed to incur a minimum penalty.
Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
*/
public class MinimumPenaltyForAShop2483 {
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYYNYYNNYYNYYNYYNYYNYYNYNNYYYYNYNNNYYNNNNNNNNNNNN"));
        System.out.println(bestClosingTime("YYNY"));
        System.out.println(bestClosingTime("NNNNN"));
        System.out.println(bestClosingTime("YYYY"));
    }

    public static int bestClosingTime(String customers) {
        int minPenalty = 0;
        int minClosingTime = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                minPenalty++;
            }
        }
        if (minPenalty == 0) {
            return minClosingTime;
        } else if (minPenalty == customers.length()) {
            return minPenalty;
        }
        int currentPenalty = minPenalty;
        for (int i = 1; i <= customers.length(); i++) {
            if (customers.charAt(i - 1) == 'Y') {
                currentPenalty--;
            } else {
                currentPenalty++;
            }
            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                minClosingTime = i;
            }
        }
        return minClosingTime;
    }
}
