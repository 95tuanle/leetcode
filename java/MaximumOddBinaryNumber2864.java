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
    }

    public static String maximumOddBinaryNumber(String s) {
        int oneCounter = 0;
        for (char c : s.toCharArray()) if (c == '1') oneCounter++;
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < s.length() - 1; i++)
            if (i < oneCounter - 1) result.append('1');
            else result.append('0');
        result.append('1');
        return result.toString();
    }
}
