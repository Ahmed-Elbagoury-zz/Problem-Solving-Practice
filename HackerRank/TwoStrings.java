import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public boolean intersect(String s1, String s2){
        if(s1 == null && s2 == null)
             return true;
        if(s1.length() == 0 && s2.length() == 0)
            return true;
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < s2.length(); i++)
            set.add(s2.charAt(i));
        for(int i = 0; i < s1.length(); i++){
            if(set.contains(s1.charAt(i)))
                return true;
        }
        return false;
    }    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < T; i++){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            Solution solution = new Solution();
            System.out.println(solution.intersect(s1, s2) ? "YES" : "NO");
        }
    }
}
