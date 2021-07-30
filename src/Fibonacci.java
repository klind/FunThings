public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fib(5));
        System.out.println(new Fibonacci().fib(5, new int[5+1]));
        System.out.println(new Fibonacci().fibIter(5));

    }

    // Iterative
    public int fibIter(int n)
    {
        if (n == 0)
            return 0;
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Recursive
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // Recursive Dynamic Programming
    public int fib(int n, int[] memo) {
        if(memo[n] != 0)
            return memo[n];
        if (n <= 1) {
            return n;
        }
        int result = fib(n-1, memo) + fib(n-2, memo);
        memo[n] = result;
        return result;
    }

}
