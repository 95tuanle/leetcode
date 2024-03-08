/*
You are given an array nums consisting of positive integers.
Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
The frequency of an element is the number of occurrences of that element in the array.
*/
public class CountElementsWithMaximumFrequency3005 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(maxFrequencyElements(nums));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(maxFrequencyElements(nums2));

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println(maxFrequencyElements(nums3));
    }

    public static int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        for (int num : nums) {
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }
        int sum = 0;
        for (int f : freq) if (f == maxFreq) sum += f;
        return sum;

//        HashMap<Integer, Integer> freqMap = new HashMap<>();
//        int maxFreq = 0;
//        for (int num : nums) {
//            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//            maxFreq = Math.max(maxFreq, freqMap.get(num));
//        }
//        int sum = 0;
//        for (int f : freqMap.values()) if (f == maxFreq) sum += f;
//        return sum;

//        int[] freq = new int[101];
//        for (int num : nums) freq[num]++;
//        Arrays.sort(freq);
//        int max = freq[100], sum = freq[100];
//        for (int i = 99; i >= 0; i--)
//            if (freq[i] == max) sum += freq[i];
//            else break;
//        return sum;

//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        int max = 0, sum = 0;
//        for (int num : nums) {
//            int freq = hashMap.getOrDefault(num, 0) + 1;
//            hashMap.put(num, freq);
//            if (freq > max) {
//                max = freq;
//                sum = max;
//            } else if (freq == max) sum += freq;
//        }
//        return sum;
    }
}
