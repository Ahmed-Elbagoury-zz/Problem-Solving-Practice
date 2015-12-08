//http://oj.leetcode.com/problems/subsets/
public class Subset{
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if(S == null || S.length == 0) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
        subsetHelper(sol,  new ArrayList<Integer>(), S, 0);
        return sol;
    }
    
    public void subsetHelper (ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> cur, int [] S, int ind) {
        if(ind == S.length){ 
            sol.add(new ArrayList<Integer> (cur));
            return;
        }
        subsetHelper(sol, cur, S, ind+1);
        cur.add(S[ind]);
        subsetHelper(sol, cur, S, ind+1);
        cur.remove(cur.size()-1);
    }

}