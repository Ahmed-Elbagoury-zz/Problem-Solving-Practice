//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicates2 {
     public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A == null) return 0;
        if(A.length < 3) return A.length;
        int ind = 2;
        int preLast = A[0];
        int last = A[1];
        for (int i = 2; i < A.length; i++){
            if(A[i] != preLast || A[i] != last){
                last = A[i];
                preLast = A[i-1];
                A[ind] = A[i];
                ind ++;
            }
        }
        return ind;
    }  

}
