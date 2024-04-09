/*
There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.
You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i].
Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will leave the line.
Return the time taken for the person at position k (0-indexed) to finish buying tickets.
*/
public class TimeNeededToBuyTickets2073 {
    public static void main(String[] args) {
        int[] tickets = {2, 3, 4, 5, 6};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));

        tickets = new int[]{5, 5, 5, 5, 5};
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int result = 0, kTickets = tickets[k], i = 0;
        for (; i <= k; i++) result += Math.min(tickets[i], kTickets);
        kTickets--;
        for (; i < tickets.length; i++) result += Math.min(tickets[i], kTickets);
        return result;
    }
}
