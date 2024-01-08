
import java.util.Stack;

/*
You are given a string s, which contains stars *.
In one operation, you can:
Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.
Note:
The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.
*/
public class RemovingStarsFromAString2390 {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));
        System.out.println(removeStars("*a*b*c*d*e*f*g*h*i*j*k*l*m*n*o*p*q*r*s*t*u*v*w*x*y*z"));
    }

    public static String removeStars(String s) {
        Stack<Character> charStack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char character : charArray)
            if (character == '*' && !charStack.isEmpty()) charStack.pop();
            else if (character != '*') charStack.push(character);
        StringBuilder stringBuilder = new StringBuilder(charStack.size());
        for (Character character : charStack) stringBuilder.append(character);
        return stringBuilder.toString();
    }
}
