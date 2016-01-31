
public class RadixSort {

	public int getMax(int [] arr){
		int max = 0;
		for(int i : arr){
			max = Math.max(max, i);
		}
		return max;
	}
	public int[] radixSort(int [] arr, int base){
		if(arr == null || arr.length == 0)	
			return arr;
		int max = getMax(arr);
		int exp = 1;
		while(max / exp > 0){
			countSort(arr, exp, base);
			exp *= 10;
		}
		return arr;
	}
	
	public void countSort(int [] arr, int exp, int base){
		int n = arr.length;
		int[] count = new int [base];
		int [] sorted = new int [n];
		for(int num : arr){
			int index = (num/exp)%base;
			count[index] ++;
		}
		for(int i = 1; i < count.length; i++){
			count[i] += count[i-1];
		}
		for(int i = n-1; i >= 0; i--){
			int num = arr[i];
			int index = (num/exp)%base;
			sorted[count[index] -1] = num;
			count[index] --;
		}
		for(int i = 0; i < n; i++){
			arr[i] = sorted[i];
		}
	}
	public static void main(String[] args) {
		RadixSort radixSort = new RadixSort();
		int [] arr = new int []{170, 45, 75, 90, 802, 24, 2, 66};
		radixSort.radixSort(arr, 10);
		for(int num : arr){
			System.out.println(num);
		}
	}

}
