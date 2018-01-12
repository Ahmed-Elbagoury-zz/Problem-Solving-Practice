class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> solution = new LinkedList<String>();
        if(s.length () > 3)
            restore(s, 0, 0, solution, new String [4]);
        return solution;
    }
        
    public void restore(String s, int index, int dotCounter, List<String> solution, String[] curArr){
        if(index == s.length()){
            return;
        }
        if(dotCounter == 3){
            if(s.substring(index).length() == 0 || s.length() - index > 3 ||(s.substring(index).length() != 1 && s.charAt(index) == '0')||Integer.parseInt(s.substring(index)) > 255){
                return;
            }
            curArr[dotCounter] = s.substring(index);
            solution.add(curArr[0] + "." + curArr[1] + "." + curArr[2] + "." + curArr[3]);
            return;
        }
        if(s.charAt(index) == '0'){
            curArr[dotCounter] = "0";
            restore(s, index + 1, dotCounter + 1, solution, curArr);
            return;
        }
        for(int i = index; i < index + 3 && i < s.length(); i++){
            String substring = s.substring(index, i +1);
            if(Integer.parseInt(substring) <= 255){
                curArr[dotCounter] = substring;
                restore(s, i+1, dotCounter+1, solution, curArr);
            }
            else{
                continue;
            }
        }
    }
}
