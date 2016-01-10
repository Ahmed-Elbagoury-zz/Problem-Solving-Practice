import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public String nextString(String str){
        int p = -1;
        int n = str.length();
        for(int i = n-2; i >= 0; i--){
            if(str.charAt(i) < str.charAt(i+1)){
                p = i;
                break;
            }
        }
        if(p == -1)
            return "no answer";
        int q = -1;
        for(int i = n-1; i >= 0; i--){
            if(str.charAt(i) > str.charAt(p)){
                q = i;
                break;
            }
        }
        if(q == -1)
            return "no answer";
        char [] arr = str.toCharArray();
        char temp = arr[p];
        //Swap chars at p and q
        arr[p] = arr[q];
        arr[q] = temp;
        //reverse chars from p+1 to n-1
        int st = p+1;
        int end = n-1;
        while(st < end){
            temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution solution = new Solution();
        Scanner scanner = new Scanner (System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < T; i++)
            System.out.println(solution.nextString(scanner.nextLine()));
        scanner.close();
    }
}
