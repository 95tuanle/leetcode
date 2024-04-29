/*
You are given a 0-indexed integer array nums and a positive integer k.
You can apply the following operation on the array any number of times:
Choose any element of the array and flip a bit in its binary representation. Flipping a bit means changing a 0 to 1 or vice versa.
Return the minimum number of operations required to make the bitwise XOR of all elements of the final array equal to k.
Note that you can flip leading zero bits in the binary representation of elements. For example, for the number (101)2 you can flip the fourth bit and obtain (1101)2.
*/
public class MinimumNumberOfOperationsToMakeArrayXOREqualToK2997 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 2, 3, 4}, 11)); // 2
        System.out.println(minOperations(new int[]{5, 6, 7, 8}, 15)); // 1
        System.out.println(minOperations(new int[]{3, 4, 5, 6, 7}, 3)); // 3
    }

    public static int minOperations(int[] nums, int k) {
        int result = 0, finalXor = 0;
        for (int num : nums) finalXor ^= num;
        while (k > 0 || finalXor > 0) {
            if (k % 2 != finalXor % 2) result++;
            k /= 2;
            finalXor /= 2;
        }
        return result;
    }
}
