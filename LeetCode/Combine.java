//http://oj.leetcode.com/problems/combinations/
public class Combine {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
        if(n == 0 || k == 0) return sol;
        helper(sol, new ArrayList<Integer>(), n, k, 1);
        return sol;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> curList, int n, int k, int ind){
        if(ind == n+1 || curList.size() == k){
            if(curList.size() == k)
                sol.add(new ArrayList(curList));
            return;    
        }
        helper(sol, curList, n, k, ind+1);
        curList.add(ind);
        helper(sol, curList, n, k, ind+1);
        curList.remove(curList.size()-1);
    }
}
