import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Example 2:
 *
 * Input: s = "IV"
 * Output: 4
 * Example 3:
 *
 * Input: s = "IX"
 * Output: 9
 * Example 4:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(RomanToInteger.romanToInteger("III"));
        System.out.println(RomanToInteger.romanToInteger("IV"));
        System.out.println(RomanToInteger.romanToInteger("IX"));
        System.out.println(RomanToInteger.romanToInteger("LVIII"));
        System.out.println(RomanToInteger.romanToInteger("MCMXCIV"));
        System.out.println(RomanToInteger.romanToInteger("III"));

    }

    public static Integer romanToInteger(String s) {
        Integer result = 0;

        Map<Character, Integer> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put('I', 1);
        romanToIntegerMap.put('V', 5);
        romanToIntegerMap.put('X', 10);
        romanToIntegerMap.put('L', 50);
        romanToIntegerMap.put('C', 100);
        romanToIntegerMap.put('D', 500);
        romanToIntegerMap.put('M', 1000);

        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return romanToIntegerMap.get(chars[0]);

        int i = 0;
        while (i < length) {
            Integer currentValue = romanToIntegerMap.get(chars[i]);
            Integer nextValue = 0;
            if (i + 1 < length) {
                nextValue = romanToIntegerMap.get(chars[i + 1]);
            }
            if (currentValue >= nextValue) {
                result = result + currentValue;
                i++;
            } else {
                result = result + (nextValue - currentValue);
                i += 2;
            }
        }

        return result;
    }


}
