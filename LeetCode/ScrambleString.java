//https://leetcode.com/problems/scramble-string/
public class ScrambleString{
	public boolean isScramble(String s1, String s2) {
       if(s1 == null || s2 == null)
           return false;
       if(s1.length() != s2.length())    
           return false;
       return helper(s1, s2);    
   }
   
   public boolean helper(String s1, String s2){
       if(s1.length() != s2.length())
           return false;
       if(s1.compareTo(s2) == 0)
    	   return true;
    	   
       char [] arr1 = s1.toCharArray();
       char [] arr2 = s2.toCharArray();
       Arrays.sort(arr1);
       Arrays.sort(arr2);
       for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i])
                return false;
       }
       for(int i = 1; i < s1.length(); i++){
    	   for(int j = 1; j < s2.length(); j++){
	           String s11 = s1.substring(0, i);
	           String s12 = s1.substring(i);
	           String s21 = s2.substring(0, j);
	           String s22 = s2.substring(j);
               if( ( helper(s11, s21) && helper(s12, s22) ) || (helper(s11, s22) && helper(s12, s21) ))
                    return true;
    	   }
       }
       return false;
   }

}