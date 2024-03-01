/*
You are given a binary string s that contains at least one '1'.
You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.
Return a string representing the maximum odd binary number that can be created from the given combination.
Note that the resulting string can have leading zeros.
*/
public class MaximumOddBinaryNumber2864 {
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("101"));
        System.out.println(maximumOddBinaryNumber("110"));
        System.out.println(maximumOddBinaryNumber("100"));
        System.out.println(maximumOddBinaryNumber("111"));
        System.out.println(maximumOddBinaryNumber("10000000000000000000000000000000"));
        System.out.println(maximumOddBinaryNumber("10000000000000000000000000000001"));
        System.out.println(maximumOddBinaryNumber("1"));
    }

    public static String maximumOddBinaryNumber(String s) {
        char[] bits = s.toCharArray();
        int left = 0, right = bits.length - 1;
        while (left <= right) {
            if (bits[left] == '1') left++;
            if (bits[right] == '0') right--;
            if (left <= right && bits[left] == '0' && bits[right] == '1') {
                bits[left] = '1';
                bits[right] = '0';
            }
        }
        bits[left - 1] = '0';
        bits[bits.length - 1] = '1';
        return new String(bits);

//        int oneCounter = 0;
//        for (char c : s.toCharArray()) if (c == '1') oneCounter++;
//        StringBuilder result = new StringBuilder(s.length());
//        for (int i = 0; i < s.length() - 1; i++)
//            if (i < oneCounter - 1) result.append('1');
//            else result.append('0');
//        result.append('1');
//        return result.toString();
    }
}
