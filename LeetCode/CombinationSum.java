//https://leetcode.com/problems/combination-sum/
public class CombinationSum{
	 List<List<Integer>> sol;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sol = new LinkedList<List<Integer>>();
        if(candidates != null && candidates.length != 0){
            Arrays.sort(candidates);
            helper(candidates, 0, target, new LinkedList<Integer>());
        }
        return sol;
            
    }
    
    public void helper(int [] candidates, int st, int target, List<Integer> curList){
        if(target == 0){
            List<Integer> copy = new LinkedList<Integer>(curList);
            sol.add(copy);
            return;
        }
        for(int i = st; i < candidates.length; i++){
            if(candidates[i] > target){
                return;
            }
            curList.add(candidates[i]);
            helper(candidates, i, target - candidates[i], curList);
            curList.remove(curList.size() - 1);
        }
    }
}