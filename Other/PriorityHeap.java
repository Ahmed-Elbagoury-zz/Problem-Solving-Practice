import java.util.Comparator;


public class PriorityHeap {
	int [] arr;
	int estimatedSize;
	int size;
	Comparator<Integer> compartor;
	public PriorityHeap(int estimatedSize, Comparator<Integer> comparator){
		this.estimatedSize = estimatedSize;
		this.arr = new int[estimatedSize + 1];
		this.compartor = comparator;
		this.size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	public int peek(){
		return arr[1];
	}
	
	private void heapifyDown(){
		int cur = arr[1];
		int curIndex = 1;
		while(curIndex <= size){
			int tempIndex = -1;
			if(curIndex* 2 <= size && curIndex * 2 + 1 <= size){
				int result = compartor.compare(arr[curIndex*2], arr[curIndex*2 + 1]);
				if(result == -1)
					tempIndex = curIndex * 2;
				else
					tempIndex = curIndex * 2 + 1;
			}
			else if(curIndex* 2 <= size ){
				tempIndex = curIndex * 2;
			}
			if(tempIndex == -1){
				curIndex = size + 1;
				continue;
			}
			int result = compartor.compare(cur, arr[tempIndex]);
			if(result == -1){
				curIndex = size + 1;
			}
			else{
				arr[curIndex] = arr[tempIndex];
				arr[tempIndex] = cur;
				curIndex = tempIndex;
			}
		}
	}
	
	public int poll(){
		if(size == 0)
			return -1;
		int result = arr[1];
		arr[1] = arr[size];
		size --;
		heapifyDown();
		return result;
	}
	
	public void add(int num){
		if(size == arr.length-1){
			reallocate();
		}
		arr[++size] = num;
		heapifyUp();
	}
	
	private void reallocate(){
		estimatedSize = 2*(estimatedSize+1) + 1;
		int[] temp = new int[estimatedSize];
		for(int i = 1; i < arr.length; i++){
			temp[i] = arr[i];
		}
		arr = temp;
	}
	
	public void heapifyUp(){
		int curIndex = size;
		int cur = arr[curIndex];
		while(curIndex > 1){
			int result = compartor.compare(cur, arr[curIndex/2]);
			if(result == 1){
				curIndex = -1;
				continue;
			}
			arr[curIndex] = arr[curIndex/2];
			arr[curIndex/2] = cur;
			curIndex /= 2;
		}
	}
	
	public static void main (String [] args){
		PriorityHeap pH = new PriorityHeap(3, new Comparator<Integer>() {
			public int compare(Integer int1, Integer int2){
				if(int1 < int2)
					return -1;
				else if(int1 > int2)
					return 1;
				return 0;
			}
		});
		
		pH.add(1);
		System.out.println(pH.peek());
		pH.add(2);
		System.out.println(pH.peek());
		pH.add(-1);
		pH.add(10);
		pH.add(-10);
		pH.add(100);
		System.out.println(pH.peek());
	}
}
