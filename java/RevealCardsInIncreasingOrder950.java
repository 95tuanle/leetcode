import java.util.Arrays;
import java.util.LinkedList;

/*
You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].
You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
You will do the following steps repeatedly until all cards are revealed:
Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1. Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.
Note that the first entry in the answer is considered to be the top of the deck.
*/
public class RevealCardsInIncreasingOrder950 {
    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));

        deck = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int length = deck.length;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) queue.add(i);
        int[] result = new int[length];
        for (int i : deck) {
            result[queue.poll()] = i;
            queue.offer(queue.poll());
        }
        return result;
    }
}
