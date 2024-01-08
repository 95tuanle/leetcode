package java;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it, as shown:
*/
public class PascalsTriangleII119 {
    public static void main(String[] args) {
        System.out.println(getRow(3));
        System.out.println(getRow(0));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long value = 1;
        for (int i = 0; i <= rowIndex; i++) {
            result.add((int) value);
            value = value * (rowIndex - i) / (i + 1);
        }
        return result;

//        Integer[] result = new Integer[rowIndex + 1];
//        Arrays.fill(result, 0);
//        result[0] = 1;
//        for (int i = 1; i <= rowIndex; i++) for (int j = i; j > 0; j--) result[j] = result[j - 1] + result[j];
//        return Arrays.asList(result);
    }

}
