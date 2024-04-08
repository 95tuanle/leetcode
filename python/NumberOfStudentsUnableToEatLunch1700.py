# The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1
# respectively. All students stand in a queue. Each student either prefers square or circular sandwiches. The number
# of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each
# step: If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and
# leave the queue. Otherwise, they will leave it and go to the queue's end. This continues until none of the queue
# students want to take the top sandwich and are thus unable to eat. You are given two integer arrays students and
# sandwiches where sandwiches[i] is the type of the ith sandwich in the stack (i = 0 is the top of the stack) and
# students[j] is the preference of the jth student in the initial queue (j = 0 is the front of the queue). Return the
# number of students that are unable to eat.
from typing import List


def countStudents(students: List[int], sandwiches: List[int]) -> int:
    result, zero_students, one_students = len(sandwiches), 0, 0
    for student in students:
        if student == 0:
            zero_students += 1
        else:
            one_students += 1
    for sandwich in sandwiches:
        if sandwich == 0:
            if zero_students > 0:
                result -= 1
                zero_students -= 1
            else:
                return result
        else:
            if one_students > 0:
                result -= 1
                one_students -= 1
            else:
                return result
    return result


if __name__ == "__main__":
    print(countStudents([1, 1, 0, 0], [0, 1, 0, 1]))
    print(countStudents([1, 1, 1, 0, 0, 1], [1, 0, 0, 0, 1, 1]))
