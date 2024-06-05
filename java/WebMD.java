/*
FizzBuzz
*/
public class WebMD {
    public static void main(String[] args) {
        printWebMD();
    }

    private static void printWebMD() {
        for (int i = 1; i <= 100; i++) {
            int three = i % 3, five = i % 5;

            if (three == 0 && five == 0) {
                System.out.println("WebMD");
            } else {
                if (three == 0) {
                    System.out.println("Web");
                } else if (five == 0) {
                    System.out.println("MD");
                } else {
                    System.out.println(i);
                }
            }
        }
    }
}
