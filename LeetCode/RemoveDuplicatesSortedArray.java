//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 0;
        int indxWrite = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] != A[i-1]){
                A[indxWrite ++] = A[i];
            }
        }
        return indxWrite;
    }
}
