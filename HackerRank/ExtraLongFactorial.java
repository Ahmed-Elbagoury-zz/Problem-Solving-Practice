import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public BigInteger factorial(int n){
        BigInteger result = new BigInteger("1");
        for(int i = 1; i <= n; i++){
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.factorial(n).toString());
    }
}
