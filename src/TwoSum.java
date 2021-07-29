import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = {3, 2, 4};
        int[] c = {3, 3};


        System.out.println("[0, 1] : " + Arrays.toString(twoSumBruteForce(a, 9)));
        System.out.println("[1, 0] : " + Arrays.toString(twoSumHashMap(a, 9)));

        System.out.println("[1, 2] : " + Arrays.toString(twoSumBruteForce(b, 6)));
        System.out.println("[2, 1] : " + Arrays.toString(twoSumHashMap(b, 6)));

        System.out.println("[0, 1] : " + Arrays.toString(twoSumBruteForce(c, 6)));
        System.out.println("[1, 0] : " + Arrays.toString(twoSumHashMap(c, 6)));

    }


    // O(n)
    // Using a hashmap to keep track on visited elements
    public static int[] twoSumHashMap(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int need = target - n;
            if (map.containsKey(need)) {
                result[0] = i;
                result[1] = map.get(need);
                break;
            }
            map.put(n, i);
        }
        return result;
    }


    // O(n2)
    // Bruteforce by creating two for loops
    public static int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        c:
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int m = nums[j];
                if (n + m == target) {
                    result[0] = i;
                    result[1] = j;
                    break c;
                }
            }
        }
        return result;
    }


}
