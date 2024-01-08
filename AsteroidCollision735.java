import java.util.Arrays;
import java.util.Stack;

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
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -i)
                stack.pop();  // Destroy smaller asteroid moving left
            if (stack.isEmpty() || i > 0 || stack.peek() < 0)
                stack.push(i);  // No collision or current asteroid is moving right
            else if (i < 0 && stack.peek() == -i) stack.pop();  // Both asteroids have equal sizes, destroy both
//            if (stack.empty()) {
//                stack.push(i);
//            } else {
//                if (stack.peek() > 0 && i < 0) {
//                    while (stack.peek() > 0) {
//                        int absI = Math.abs(i);
//                        if (stack.peek() < absI) {
//                            stack.pop();
//                            if (stack.empty()) {
//                                stack.push(i);
//                                break;
//                            }
//                            if (stack.peek() > absI) {
//                                break;
//                            }
//                            if (stack.peek() < 0) {
//                                stack.push(i);
//                            }
//                        } else if (stack.peek() == absI) {
//                            stack.pop();
//                            break;
//                        } else {
//                            break;
//                        }
//                    }
//                } else {
//                    stack.push(i);
//                }
//            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
