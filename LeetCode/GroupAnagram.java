//https://leetcode.com/problems/anagrams/
public class GroupAnagram{
	 public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new LinkedList<List<String>>();
        if(strs == null || strs.length == 0)
            return sol;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();    
        Arrays.sort(strs);
        for(int i = 0 ; i < strs.length; i ++){
            String str = strs[i];
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String str2 = new String(arr);
            if(map.containsKey(str2))
                map.get(str2).add(str);
            else{
                List<String> list = new LinkedList<String> ();
                list.add(str.toLowerCase());
                map.put(str2, list);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            sol.add(entry.getValue());
        }
        return sol;
    }

}