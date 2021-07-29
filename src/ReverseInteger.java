import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * Example 4:
 * <p>
 * Input: x = 0
 * Output: 0
 */
public class ReverseInteger {

    public static void main(String[] args) {

        System.out.println("321 : " + reverse(123));
        System.out.println("-321 : " + reverse(-123));
        System.out.println("21 : " + reverse(120));
        System.out.println("0 : " + reverse(-2147483648));
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            if ((result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && lastDigit > 7)) || (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && lastDigit < -8))) {
                result = 0;
                break;
            }
            result = result * 10 + lastDigit;
            x /= 10;
        }
        return result;
    }

}
