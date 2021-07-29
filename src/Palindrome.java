public class Palindrome {

    public static void main(String[] args) {


        System.out.println("true = " + Palindrome.isPalindrome("A man, a plan, a canal: panama".toLowerCase()));
        System.out.println("false = " + Palindrome.isPalindrome("Race a car".toLowerCase()));
        System.out.println("true = " + Palindrome.isPalindrome(121));
        System.out.println("false = " + Palindrome.isPalindrome(-121));
        System.out.println("false = " + Palindrome.isPalindrome(10));
        System.out.println("false = " + Palindrome.isPalindrome(-101));

    }

    /**
     * Given an integer x, return true if x is palindrome integer.
     * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
     *
     * Example 1:
     *
     * Input: x = 121
     * Output: true
     * Example 2:
     *
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: x = 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     * Example 4:
     *
     * Input: x = -101
     * Output: false
     */
    public static boolean isPalindrome(int number) {
        boolean isPalindrome = false;
        int reverseValue = 0;
        int originalNumber = number;
        // When x < 0, x is not a palindrome.
        // Also: if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(number < 0 || (number % 10 == 0 && number != 0)) {
            return isPalindrome;
        }
        while (number > 0) {
            // "number % 10" will return the last digit
            int lastInt = number % 10;
            reverseValue = reverseValue * 10 + lastInt;
            // Remove the last digit from number
            number = number / 10;
        }
        System.out.println("original number " + originalNumber + " : " + "reversed number " + reverseValue);
        if (originalNumber == reverseValue)
            isPalindrome = true;
        return isPalindrome;

    }

    /**
     * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Example 1:
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * Example 2:
     *
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        // Store all letters and digits in new string. We don't care about space and special characters etc.
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                builder.append(Character.toLowerCase(ch));
            }
        }
        String s1 = builder.toString();
        boolean palindrome = true;
        int length = s1.length();
        int frontIndex = 0;
        int backIndex = length - 1;
        // Two indexes, one that points to the first index and one to the last index
        while (frontIndex < backIndex) {
            char c1 = s1.charAt(frontIndex);
            char c2 = s1.charAt(backIndex);
            if (c1 != c2) {
                palindrome = false;
                break;
            }
            frontIndex += 1;
            backIndex -= 1;
        }
        return palindrome;
    }

}
