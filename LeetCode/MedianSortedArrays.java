//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianSortedArrays{
	//Time: O(m+n). Space : O(1)
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         if(nums1 == null || nums1.length == 0){
        	 if(nums2.length % 2 == 0)
        		 return (1.0 * nums2[nums2.length/2] + nums2[nums2.length/2 - 1]) /2;
             return nums2[nums2.length/2];
         }
         if(nums2 == null || nums2.length == 0){
        	 if(nums1.length % 2 == 0)
        		 return (1.0 * nums1[nums1.length/2] + nums1[nums1.length/2 - 1]) /2;
             return nums1[nums1.length/2];
         }
         int m = nums1.length;
         int n = nums2.length;
         int i = 0;
         int j = 0;
         int val1 = -1;
         int val2 = -1;
         int count = 0;
         int target1 = -1;
         int target2 = -1;
         if((m + n) % 2 != 0)
             target1 = (m+n)/2;
         else{
             target1 = ((m+n)/2) - 1;
             target2 = target1 + 1;
         }    
         boolean flag = true;
         while(flag){
             if(i < nums1.length && j < nums2.length){
                 if(nums1[i] < nums2[j]){
                     if(count == target1)
                         val1 = nums1[i];
                     else if(count == target2){
                         val2 = nums1[i];
                     }    
                     i++;
                 }
                 else{
                     if(count == target1)
                         val1 = nums2[j];
                     if(count == target2)    
                         val2 = nums2[j];
                     j++;
                 }
             }
             else{
                 if(i < nums1.length){
                     if(count == target1)
                         val1 = nums1[i];
                     else if(count == target2)
                         val2 = nums1[i];
                     i++;
                 }
                 else{
                     if(count == target1)
                         val1 = nums2[j];
                     if(count == target2)    
                         val2 = nums2[j];
                     j++;
                 }
             }
             if( (count == target1 && target2 == -1) || (count == target2) )
                 break;
             count ++;
         }
         if(target2 == -1)
             return val1;
         return (1.0 * val1+val2) / 2;
     }
}