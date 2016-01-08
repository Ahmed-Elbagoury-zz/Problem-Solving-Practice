//https://leetcode.com/problems/anagrams/
//Solution without hashmap
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new LinkedList<List<String>>();
        if(strs == null || strs.length == 0)
            return solution;
        WordIndex[] sortedStrs = new WordIndex[strs.length];   
        for(int i = 0; i < strs.length; i++){
        	char [] curArr = strs[i].toLowerCase().toCharArray();
        	Arrays.sort(curArr);
        	sortedStrs[i] = new WordIndex(new String(curArr), i);
        }
        Arrays.sort(sortedStrs);
        List<String> curList = new LinkedList<String>();
        int prevInd = sortedStrs[strs.length-1].index;
        String prevStr = sortedStrs[strs.length-1].word;
        curList.add(strs[prevInd]);
        for(int i = strs.length-2; i >= 0; i--){
            String curStr = sortedStrs[i].word;
            int curInd = sortedStrs[i].index;
            if(curStr.compareTo(prevStr) != 0){
                curList = sortList(curList);
                solution.add(curList);
                curList = new LinkedList<String>();
                curList.add(strs[curInd]);
                prevStr = curStr;
                prevInd = curInd;
            }
            else{
                prevStr = curStr;
                prevInd = curInd;
                curList.add(strs[prevInd]);
            }
        }
        if(curList.size()!= 0){
            curList = sortList(curList);
            solution.add(curList);
        }
        return solution;    
    }
    
    public List sortList(List<String> list){
        if(list == null || list.size() == 0)
            return list;
        String [] arr = new String[list.size()];
        Iterator<String> it = list.iterator();
        int i = 0;
        while(it.hasNext()){
            arr[i++] = it.next();
        }
        Arrays.sort(arr);
        list = new LinkedList<String>();
        for(i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }
        return list;
    }
    
    public static void main(String [] args){
    	Solution solutoin = new Solution();
    	solutoin.groupAnagrams(new String [] {"", "b", ""});
    }
}

class WordIndex implements Comparable <WordIndex>{
    String word;
    int index;
    public WordIndex(String word, int index){
        this.word = word;
        this.index = index;
    }
    public int compareTo(WordIndex w2){
        int result = word.compareTo(w2.word);
        if(result == 0)
            return 0;
        else
            return result > 0 ? 1 : -1;
    }
}
