//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSum2{
	List<List<Integer>> sol;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sol = new LinkedList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return sol;
        Arrays.sort(candidates);    
        helper(candidates, 0, new LinkedList<Integer>(), target);
        return sol;
    }
    
    public void helper(int [] candidates, int st, List<Integer> curList, int target){
        if(target == 0){
            List<Integer> temp = new LinkedList<Integer>(curList);
            sol.add(temp);
            return;
        }
        int n = candidates.length;
        for(int i = st; i < n; i++){
            if(candidates[i] > target)
                return;
            if(i > st && candidates[i] == candidates[i-1])
            	continue;
            curList.add(candidates[i]);
            helper(candidates, i+1, curList, target - candidates[i]);
            curList.remove(curList.size()-1);
        }
    }

}