import java.util.ArrayDeque;
import java.util.Arrays;

/*
We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*/
public class AsteroidCollision735 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -2, 1, -2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, 1, 1, -2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{1, -2, -2, -2})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i : asteroids) {
            while (!deque.isEmpty() && deque.peekLast() > 0 && deque.peekLast() < -i)
                deque.removeLast();  // Destroy smaller asteroid moving left
            if (deque.isEmpty() || i > 0 || deque.peekLast() < 0)
                deque.addLast(i);  // No collision or current asteroid is moving right
            else if (i < 0 && deque.peekLast() == -i)
                deque.removeLast();  // Both asteroids have equal sizes, destroy both
        }
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}
