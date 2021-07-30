import java.util.HashMap;
import java.util.Map;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(new BinaryGap().solution(1041));
        // 9 = 1001 = 2
        // 529 = 1000010001 = 4
        // 20 = 10100 = 1
        // 15 = 1111 = 0
        // 1041 = 10000010001 = 5
    }

    public int solution(int N) {
        int gapcounter = 0;
        int maxcounter = 0;
        boolean start = false;
        char[] binary = Integer.toBinaryString(N).toCharArray();
        // When we find a 1 it is a possible gap start or a gap end
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == '1') {
                if (start) {
                    if (gapcounter > maxcounter) {
                        maxcounter = gapcounter;
                    }
                }
                start = true;
                gapcounter = 0;
            } else {
                if (start)
                    gapcounter++;
            }
        }
        return maxcounter;
    }
}
