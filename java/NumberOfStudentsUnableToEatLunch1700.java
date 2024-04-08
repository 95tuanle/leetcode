/*
The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
Otherwise, they will leave it and go to the queue's end.
This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the ith sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the jth student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
*/
public class NumberOfStudentsUnableToEatLunch1700 {
    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0}, sandwiches = {0, 1, 0, 1};
        System.out.println(countStudents(students, sandwiches));

        students = new int[]{1, 1, 1, 0, 0, 1};
        sandwiches = new int[]{1, 0, 0, 0, 1, 1};
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int result = sandwiches.length, zeroStudents = 0, oneStudents = 0;
        for (int student : students)
            if (student == 0) zeroStudents++;
            else oneStudents++;
        for (int sandwich : sandwiches)
            if (sandwich == 0) {
                if (zeroStudents > 0) {
                    result--;
                    zeroStudents--;
                } else return result;
            } else {
                if (oneStudents > 0) {
                    result--;
                    oneStudents--;
                } else return result;
            }
        return result;
    }
}
