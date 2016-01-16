public class Solution {
    //Time: O(nlogn), memory: O(1)
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;
        char [] arr1 = s.toCharArray();
        char [] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
    //Time: O(n), memory: O(n)
    public boolean isAnagram(String s, String t) {
    if(s == null || t == null)
        return false;
    if(s.length() != t.length())
        return false;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for(int i = 0; i < s.length(); i++){
        int count = 1;
        char curChar = s.charAt(i);
        if(map.containsKey(curChar)){
            count += map.get(curChar);
        }
        map.put(curChar, count);
    }
    for(int i = 0; i < t.length(); i++){
        char curChar = t.charAt(i);
        if(!map.containsKey(curChar))
            return false;
        int count = map.get(curChar);
        if(count == 0)
            return false;
        map.put(curChar, count -1);
    }
    for(Map.Entry<Character, Integer> entry : map.entrySet()){
    	if(entry.getValue() != 0)
    		return false;
    }
    return true;
}
}
