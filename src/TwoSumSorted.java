import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Example 1:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * Example 2:
 * <p>
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Example 3:
 * <p>
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 */
public class TwoSumSorted {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = {2, 3, 4};
        int[] c = {-1, 0};
        System.out.println("[1, 2] : " + Arrays.toString(twoSumSortedHashMap(a, 9)));
        System.out.println("[1, 2] : " + Arrays.toString(twoSumSortedNoHashMap(a, 9)));
        System.out.println("[1, 3] : " + Arrays.toString(twoSumSortedHashMap(b, 6)));
        System.out.println("[1, 3] : " + Arrays.toString(twoSumSortedNoHashMap(b, 6)));
        System.out.println("[1, 2] : " + Arrays.toString(twoSumSortedHashMap(c, -1)));
        System.out.println("[1, 2] : " + Arrays.toString(twoSumSortedNoHashMap(c, -1)));
    }


    // O(n) considering the sorted array
    public static int[] twoSumSortedNoHashMap(int[] numbers, int target) {
        int[] result = new int[2];
        int beginIndex = 0, endIndex = numbers.length - 1;
        while (beginIndex < endIndex) {
            int t = numbers[beginIndex] + numbers[endIndex];
            if (numbers[beginIndex] + numbers[endIndex] == target) {
                result[0] = beginIndex + 1;
                result[1] = endIndex + 1;
                break;
            } else {
                if (target < t) {
                    endIndex--;
                } else {
                    beginIndex++;
                }
            }
        }
        return result;
    }

    // O(n) Not considering the sorted array but using a hashmap to keep track on visited elements
    public static int[] twoSumSortedHashMap(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            int need = target - n;
            if (map.containsKey(need)) {
                result[0] = i + 1;
                result[1] = map.get(need) + 1;
                Arrays.sort(result);
                break;
            }
            map.put(n, i);
        }
        return result;
    }


}
