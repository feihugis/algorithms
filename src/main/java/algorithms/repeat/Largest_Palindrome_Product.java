package algorithms.repeat;

public class Largest_Palindrome_Product {
  public int largestPalindrome(int n) {
    if (n == 1) return 9;

    long maxNum = (long) Math.pow(10, n) - 1;
    long minNum = (long) Math.pow(10, n-1);

    for (long i = maxNum; i >= minNum; i--) {
      long pal = createPalindrome(i);
      for (long j = maxNum; j*j >= pal; j--) {
        if ((pal % j) == 0) {
          return (int) (pal % 1337);
        }
      }
    }

    return -1;
  }

  public long createPalindrome(long n) {
    String pal = new StringBuilder(n + "").reverse().toString();
    return Long.parseLong(n + pal);
  }

  public static void main(String[] args) {
    Largest_Palindrome_Product solution = new Largest_Palindrome_Product();
    System.out.println(solution.largestPalindrome(1));
  }

}
