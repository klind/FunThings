import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RotateArray().solution(new int[]{3, 8, 9, 7, 6}, 3)));
    }

    public int[] solution(int[] A, int K) {
        if (A.length == 0)
            return A;
        K %= A.length;
        // First reverse the full array
        reverse(A, 0, A.length-1);
        // Then reverse the first part of the array up to K
        reverse(A, 0, K-1);
        // Then reverse the last part of the array from K to the end
        reverse(A, K, A.length-1);
        return A;
    }

    public void reverse(int[] a, int start, int end){
        while (start < end) {
            int t = a[start];
            a[start] = a[end];
            a[end] = t;
            start++;
            end--;
        }
    }


}
