package other.fastslowpointers;

/*Any number will be called a happy number if, after repeatedly
replacing it with a number equal to the sum of the square of all
of its digits, leads us to number ‘1’. All other (not-happy) numbers
will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.*/

/*
Input: 23
Output: true (23 is a happy number)
Explanations: Here are the steps to find out that 23 is a happy number:
2^2 + 3^2 = 13
1^2 + 3^2 = 10
1^2 + 0^2 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {
        int n = 12;
        if(isHappyNumber(n)) {
            System.out.printf("%s is a happy number.", n);
        } else {
            System.out.printf("%s is not a happy number.", n);
        }
    }

    private static boolean isHappyNumber(int number) {
        int slow = number, fast = number;
        do {
            slow = findSquaresSum(slow);
            fast = findSquaresSum(findSquaresSum((fast)));
        } while (slow != fast);
        return slow == 1;
    }

    private static int findSquaresSum(int number) {
        int sum = 0, d;
        while(number > 0) {
            d = number % 10;
            sum += (d * d);
            number /= 10;
        }
        return sum;
    }
}
