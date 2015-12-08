//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumber {
    char [][] mapping = new char [][] {{}, {}, {'a', 'b', 'c' }, {'d', 'e', 'f' }, {'g', 'h', 'i' }, {'j', 'k', 'l' }, {'m', 'n', 'o' }, {'p', 'q', 'r', 's' }, {'t', 'u', 'v' }, {'w', 'x', 'y', 'z' }};
    public ArrayList<String> letterCombinations(String digits) {
        if(digits == null) return new ArrayList<String> ();
        ArrayList<String> sol = new ArrayList<String> ();
        combinationHelper(digits, 0, sol, new StringBuilder());
        return sol;
    }
    
    public void combinationHelper(String digits, int ind, ArrayList<String> sol, StringBuilder curStr){
        if(ind == digits.length()) {
            sol.add(new String(curStr));
            return;
        }
        char[] curArr = mapping [(int)(digits.charAt(ind) - '0')];
        for(int i =0; i < curArr.length; i++){
            curStr.append(curArr[i]);
            combinationHelper(digits, ind+1, sol, curStr);
            curStr.deleteCharAt(curStr.length()-1);
        }
    }
}


