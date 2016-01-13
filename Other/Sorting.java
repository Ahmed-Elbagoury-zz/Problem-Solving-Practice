import java.util.Random;

public class Sorting{
  public Random random;	
  public Sorting(){
	  random = new Random(1);
  }
  public void bubleSort(Comparable[] arr){
      if(arr == null || arr.length == 0)
          return;
      int n = arr.length;    
      for(int i = 0; i < n-1; i++){
    	  Comparable min = arr[i];
          int minIndex = i;
          for(int j = i+1; j < n; j++){
              if(min.compareTo(arr[j]) > 0)
                  min = arr[j];
                  minIndex = j;
          }
          Comparable temp = arr[i];
          arr[i] = min;
          arr[minIndex] = temp;
      }
  }
      
      public void mergeSort(Comparable[] arr, int st, int end){
          int length = end-st+1;
          if(arr == null || length <= 1)
              return;
          if(length == 2){
              if(arr[st].compareTo(arr[end]) == 1){
            	  Comparable temp = arr[end];
                  arr[end] = arr[st];
                  arr[st] = temp;
              }
              return;
          }
          int mid = st + (end-st)/2;
          mergeSort(arr, st, mid);
          mergeSort(arr, mid+1, end);
          //Merging
          Comparable[] aux = new Comparable[length];
          int p1 = st;
          int p2 = mid+1;
          int p = 0;
          while(p1 <= mid && p2 <= end){
              if(arr[p1].compareTo(arr[p2]) == -1)
                  aux[p++] = arr[p1++];
              else
                  aux[p++] = arr[p2++];
          }
          while(p1 <= mid)
              aux[p++] = arr[p1++];
          while(p2 <= end)
              aux[p++] = arr[p2++];
          for(int i = 0; i < length; i++)
          	arr[i+st] = aux[i];
      }
      //Quick sort implementation that picks the pivot random
      public void quickSortRandomPivot(Comparable [] arr, int st, int end){
      	int length = end-st+1;
      	if(arr == null || length <= 1)
            return;
      	if(length == 2){
            if(arr[st].compareTo(arr[end]) == 1){
            	Comparable temp = arr[end];
                arr[end] = arr[st];
                arr[st] = temp;
            }
            return;
      	}
      	int pivotIndex = pickPivot(st, end);
      	Comparable pivot = arr[pivotIndex];
      	int p1 = st;
      	int p2 = end;
      	while(p1 <= p2){
  	        while(arr[p2].compareTo(pivot) == 1){
  	            p2--;
  	        }
  	        while(arr[p1].compareTo(pivot) == -1){
  	            p1++;
  	        }
  	            if(p1 <= p2){
  	            	Comparable temp =  arr[p1];
  	                arr[p1] = arr[p2];
  	                arr[p2] = temp;
  	                p1++;
  	                p2--;
  	        }
      	}
      	quickSortRandomPivot(arr, st, p2);
      	quickSortRandomPivot(arr, p1, end);
      }
        
        
      public int pickPivot(int st, int end){
//      	return st + (end-st)/2; //To pick the middle element
    	  return random.nextInt(end-st+1) + st;	//To return random number between st and end inclusive
      }
      
      public int partition(Comparable [] arr, int start, int end){
    	  	 int indLarger = start;
    	       int indSmaller = start;
    	       int pivotInd = end;
    	       Comparable pivot = arr[pivotInd];
    	       
    	       while(indSmaller < end && indLarger < end){
    	    	   while(arr[indLarger].compareTo(pivot) == -1)	   
    	           	indLarger++;
    	           indSmaller = indLarger;
    	           while(indSmaller < end && (arr[indSmaller].compareTo(pivot) > -1) )
    	               indSmaller++;
    	           Comparable temp = arr[indLarger];
    	           arr[indLarger] = arr[indSmaller];
    	           arr[indSmaller] = temp;
    	           pivotInd = indLarger;
    	           indLarger++;
    	       }
    	       return pivotInd;
    	  }
    	  public void quickSortPivotIsLast(Comparable [] arr, int start, int end){
    	      if(start >= end)
    	          return;
    	      int pivotInd = partition(arr, start, end);
    	      for(int i = 0; i < arr.length; i++){
    	          System.out.print(arr[i]);
    	          if(i != arr.length-1)
    	              System.out.print(" ");
    	      }
    	      System.out.println();
    	      quickSortPivotIsLast(arr, start, pivotInd-1);
    	      quickSortPivotIsLast(arr, pivotInd+1, end);
    	  }


    
    public static void main(String[] args){
    	Integer [] arr = new Integer [] {5, 3, 1, 2, 6 ,4, 7};
    	Sorting sorting = new Sorting();
    	sorting.quickSortRandomPivot(arr, 0, arr.length-1);
    	System.out.println("---------");
    	for(Integer i : arr)
    		System.out.print(i + ", ");
    }
}
