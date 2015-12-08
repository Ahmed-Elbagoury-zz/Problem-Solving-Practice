//https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesis {
    ArrayList<String> sol;
    int numleft;
    int numright;
    char [] curStr;
    int num;
    public ArrayList<String> generateParenthesis(int n) {
        sol = new ArrayList<String> ();
        curStr = new char[2*n];
        num = 2*n;
        recSol(0);
        // Start typing your Java solution below
        // DO NOT write main() function
        return sol;
    }
    
    public void recSol(int index){
        if(index == num){
            sol.add(new String(curStr));
        }
        if(numleft < num/2){
            numleft ++;
            curStr[index] = '(';
            recSol(index+1);
            numleft--;
        }
        if(numleft-numright > 0 && numright < num/2){
            numright ++;
            curStr[index] = ')';
            recSol(index+1);
            numright --;
        }
    }

     public ArrayList<String> generateParenthesis2(int n) {
        if(n <= 0) return new ArrayList<String>();
        ArrayList<String> sol = new ArrayList<String>();
        generateHelper(n, new StringBuilder (), sol, 0, 0);
        return sol;
    }
    
    public void generateHelper(int n, StringBuilder curSol, ArrayList<String> sol, int numLeft, int numRight){
        if(numLeft == n && numRight == n){
            sol.add(curSol.toString());
            return;
        }
        if(numLeft < n){
            curSol.append('(');
            generateHelper(n, curSol, sol, numLeft+1, numRight);
            curSol.delete(curSol.length()-1, curSol.length());
        }
        if(numLeft > numRight && numRight < n){
            curSol.append(')');
            generateHelper(n, curSol, sol, numLeft, numRight+1);
            curSol.delete(curSol.length()-1, curSol.length());
        }
    }
}

