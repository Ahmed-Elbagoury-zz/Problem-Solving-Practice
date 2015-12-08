//https://leetcode.com/problems/permutations/
public class Permutation{
	 public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num == null) return null;
        ArrayList<ArrayList<Integer> > sol = new ArrayList<ArrayList<Integer> > ();
       
        permuteHelper(sol, new ArrayList <Integer>(), num, new boolean [num.length], 0);
        return sol;
    }
    
    public void permuteHelper (ArrayList <ArrayList <Integer> > sol, ArrayList<Integer> cur, int [] num, boolean[] visited, int ind){
            if(ind == num.length){
                ArrayList<Integer> copy = new ArrayList <Integer> (cur);
                sol.add(copy);
            }
            for(int i =0 ; i < num.length; i ++){
                if(visited [i]) continue;
                visited[i] = true;
                cur.add(num[i]);
                permuteHelper(sol, cur, num, visited, ind+1);
                visited[i] = false;
                cur.remove(ind);
            }
        }

}