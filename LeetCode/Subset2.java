//https://leetcode.com/problems/subsets-ii/
public class Subset2{
	List<List<Integer>> sol;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        sol = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return sol;
        Arrays.sort(nums);    
        helper(0, nums, new boolean[nums.length], new LinkedList<Integer>());
        return sol;
    }
    
    public void helper(int ind, int [] nums, boolean [] visited, List<Integer> curSol){
        List<Integer> temp = new LinkedList<Integer>(curSol);
        if(ind == nums.length){
            sol.add(temp);
            return;
        } 
        sol.add(temp);
        for(int i = ind; i < nums.length; i++){
            if(visited[i])
                continue;
//If the same element is ignored twice, we will get the same solution
//[1, 1, 1]
            if(i != 0 && nums[i] == nums[i-1] && !visited[i-1])    
                continue;
            visited[i] = true;
            curSol.add(nums[i]);
            helper(i+1, nums, visited, curSol);
            curSol.remove(curSol.size()-1);
            visited[i] = false;
        }
    }





}