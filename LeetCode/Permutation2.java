//https://leetcode.com/problems/permutations-ii/
public class Permutation2{
    List<List<Integer>> sol;
    public List<List<Integer>> permuteUnique(int[] nums) {
        sol = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return sol;
        Arrays.sort(nums);    
        helper(nums, new boolean[nums.length], new LinkedList<Integer>(), 0);
        return sol;
    }
    
    public void helper(int [] nums, boolean [] visited, List<Integer> curSol, int ind){
        if(curSol.size() == nums.length){
            sol.add(new LinkedList<Integer>(curSol));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            curSol.add(nums[i]);
            helper(nums, visited, curSol, ind+1);
            visited[i] = false;
            curSol.remove(curSol.size()-1);
            //Eleminate all elements that are similar to the current number from consideration for the current position
            while(i < nums.length-1 && nums[i] == nums[i+1])
                i++;
        }
    }

}