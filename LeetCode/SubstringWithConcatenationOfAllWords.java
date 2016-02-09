public class Solution {
            public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> solution = new LinkedList<Integer>();
        if(s == null || s.length() == 0 || words == null || words.length == 0)
            return solution;
        Map<String, Integer> toBeFound = new HashMap<String, Integer>();
        for(String str : words){
            int count = 1;
            if(toBeFound.containsKey(str)){
                count += toBeFound.get(str);
            }
            toBeFound.put(str, count);
        }
        
        int n = s.length();
        int m = words[0].length();
        int l = words.length;
        for(int i = 0; i < m; i++){
            Map<String, Integer> found = new HashMap<String, Integer>();
            int start = i;
            int end = start;
            int count = 0;
            while(end <= n - m){
                String str = s.substring(end, end + m);
                if(!toBeFound.containsKey(str)){
                        //The string is not required, so reset everything
                    end = end + m;
                    start = end;
                    found = new HashMap<String, Integer>();
                    count = 0;
                    continue;
                }
                int c = 1;
                if(found.containsKey(str)){
                    c += found.get(str);
                }
                found.put(str, c);
                count++;
                while(found.get(str) > toBeFound.get(str)){
                        /*To handle case like this: s = "butfoofoo^thebut"
                        At the marked index we will have + one extra foo so we have to remove from the beggining
                        till we have no extra "foo"s
                        */
                    String left = s.substring(start, start+ m);
                    found.put(left, found.get(left)-1);
                    start += m;
                    count--;
                }
                if(count == l){
                    solution.add(start);
                    String left = s.substring(start, start+m);
                    found.put(left, found.get(left)-1);
                    count --;
                    start += m;
                }
                end += m;
            }
        }
        return solution;
    }
}
