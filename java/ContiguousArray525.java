import java.util.HashMap;

/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
*/
public class ContiguousArray525 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
        System.out.println(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }

    public static int findMaxLength(int[] nums) {
        int count = 0, result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0) ? -1 : 1;
            if (!hashMap.containsKey(count)) hashMap.put(count, i);
            else result = Math.max(result, i - hashMap.get(count));
        }
        return result;
    }
}
