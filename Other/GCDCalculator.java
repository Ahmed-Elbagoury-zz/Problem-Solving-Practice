public class GCDCalculator{
  public int GCD(int a, int b) {
     if (b==0) return a;
     return GCD(b,a%b);
  }
  
  public int computeGCD(int[] input)
  {
      int result = input[0];
      for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
      return result;
  }
}
