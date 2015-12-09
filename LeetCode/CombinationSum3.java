//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSum3{
	List<List<Integer>> sol;
    int setSize;
    public List<List<Integer>> combinationSum3(int k, int n) {
        sol = new LinkedList<List<Integer>>();
        if(n == 0 || k == 0)
            return sol;
        setSize = k;    
        helper(new LinkedList<Integer> (), 1, n);
        return sol;
    }
    
    public void helper(List<Integer> curList, int st, int target){
        if(target == 0){
            if(curList.size() == setSize){
                List<Integer> temp = new LinkedList<Integer>(curList);
                sol.add(temp);
            }
            return;
        }
        for(int i = st; i <= 9; i++){
            curList.add(i);
            helper(curList, i+1, target - i);
            curList.remove(curList.size()- 1);
        }
    }

}