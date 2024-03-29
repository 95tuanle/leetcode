/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
*/
public class ValidPalindrome125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char leftChar = s.charAt(left), rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)) left++;
            else if (!Character.isLetterOrDigit(rightChar)) right--;
            else if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;

//        s = s.toLowerCase();
//        int left = 0, right = s.length() - 1;
//        while (left <= right) {
//            int leftChar = s.charAt(left), rightChar = s.charAt(right);
//            if (leftChar < 48 || (leftChar > 57 && leftChar < 97) || leftChar > 122) left++;
//            else if (rightChar < 48 || (rightChar > 57 && rightChar < 97) || rightChar > 122) right--;
//            else if (leftChar != rightChar) return false;
//            else {
//                left++;
//                right--;
//            }
//        }
//        return true;
    }
}
