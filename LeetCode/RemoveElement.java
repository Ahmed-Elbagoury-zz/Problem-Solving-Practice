//https://leetcode.com/problems/remove-element/
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 0;
        int indWrite = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != elem){
                A[indWrite++] = A[i];
            }
        }
        return indWrite;
    }
}

