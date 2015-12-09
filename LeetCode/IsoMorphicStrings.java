//https://leetcode.com/problems/isomorphic-strings/
public class IsoMorphicStrings{
	//Using 2 maps
	public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1) && map.get(c1) != c2)
                return false;
            if(map2.containsKey(c2) && map2.get(c2) != c1)
                return false;
            map.put(c1, c2);    
            map2.put(c2, c1);
        }
        return true;
    }
    //Using 1 maps
    public boolean isIsomorphicUsingOneHashMap(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1) && map.get(c1) != c2)
                return false;
            Character key = getKey(map, c2);
            if(key != null && key != c1)
                return false;
            map.put(c1, c2); 
        }
        return true;
    }
    public Character getKey(HashMap<Character, Character> map, char val){
        for(Map.Entry<Character, Character> entry : map.entrySet()){
            if(entry.getValue().equals(val))
                return entry.getKey();
        }
        return null;
    }

}