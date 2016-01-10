public class Solution {
  public int partition(int [] arr, int start, int end){
  	 int indLarger = start;
       int indSmaller = start;
       int pivotInd = end;
       int pivot = arr[pivotInd];
       
       while(indSmaller < end && indLarger < end){
           while(arr[indLarger] < pivot)
           	indLarger++;
           indSmaller = indLarger;
           while(indSmaller < end && arr[indSmaller] >= pivot)
               indSmaller++;
           int temp = arr[indLarger];
           arr[indLarger] = arr[indSmaller];
           arr[indSmaller] = temp;
           pivotInd = indLarger;
           indLarger++;
       }
       return pivotInd;
  }
  public void quickSort(int [] arr, int start, int end){
      if(start >= end)
          return;
      int pivotInd = partition(arr, start, end);
      for(int i = 0; i < arr.length; i++){
          System.out.print(arr[i]);
          if(i != arr.length-1)
              System.out.print(" ");
      }
      System.out.println();
      quickSort(arr, start, pivotInd-1);
      quickSort(arr, pivotInd+1, end);
  }
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scanner = new Scanner (System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int [] arr = new int [n];
    for(int i = 0; i < n; i++){
        arr[i] = scanner.nextInt();
    }
    Solution solution = new Solution();
    solution.quickSort(arr, 0, n-1);
    scanner.close();
  }
}  
