import java.util.Arrays;

/*
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.
*/
public class BoatsToSavePeople881 {
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit)); // 3

        people = new int[]{3, 5, 3, 4};
        limit = 5;
        System.out.println(numRescueBoats(people, limit)); // 4
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0, left = 0, right = people.length;
        while (left < right) {
            result++;
            if (limit - people[--right] >= people[left]) left++;
        }
        return result;

//        Arrays.sort(people);
//        int result = 1, left = 0, right = people.length - 1, currentLimit = limit, currentPeople = 0;
//        while (left <= right) {
//            if (currentLimit >= people[right] && currentPeople < 2) {
//                currentLimit -= people[right--];
//                currentPeople++;
//            } else if (currentLimit >= people[left] && currentPeople < 2) {
//                currentLimit -= people[left++];
//                currentPeople++;
//            } else {
//                currentLimit = limit;
//                currentPeople = 0;
//                result++;
//            }
//        }
//        return result;
    }
}
