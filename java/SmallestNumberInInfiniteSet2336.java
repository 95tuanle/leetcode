/*
You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
Implement the SmallestInfiniteSet class:
SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
*/
public class SmallestNumberInInfiniteSet2336 {
    public static void main(String[] args) {
        SmallestInfiniteSet set = new SmallestInfiniteSet();
        set.addBack(2);
        System.out.println(set.popSmallest());
        System.out.println(set.popSmallest());
        System.out.println(set.popSmallest());
        set.addBack(1);
        System.out.println(set.popSmallest());
        System.out.println(set.popSmallest());
        System.out.println(set.popSmallest());
    }
}

class SmallestInfiniteSet {
    boolean[] isPopped;
    int popIndex;

    public SmallestInfiniteSet() {
        isPopped = new boolean[1001];
        popIndex = 1;
    }

    public int popSmallest() {
        while (isPopped[popIndex]) popIndex++;
        isPopped[popIndex] = true;
        return popIndex++;
    }

    public void addBack(int num) {
        if (isPopped[num]) {
            isPopped[num] = false;
            if (popIndex > num) popIndex = num;
        }
    }
}
