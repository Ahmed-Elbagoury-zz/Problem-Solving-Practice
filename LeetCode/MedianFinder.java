import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    double median;
    int ESTIMATE_SIZE = 100;
    
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(ESTIMATE_SIZE, new Comparator<Integer>(){
            public int compare(Integer int1, Integer int2){
                if(int1 > int2)
                    return 1;
                else if(int1 < int2)
                    return -1;
                else
                    return 0;
            }
        });
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(ESTIMATE_SIZE, new Comparator<Integer>(){
        public int compare(Integer int1, Integer int2){
            if(int1 > int2)
                return -1;
            else if(int1 < int2)
                return 1;
            else
                return 0;
        }   
    });    
    
    public int compareHeaps(){
        if(minHeap.size() > maxHeap.size())
            return 1;
        else if(minHeap.size() < maxHeap.size())
            return -1;
        else
            return 0;
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        int comp = compareHeaps();
        switch(comp){
            case 1: //minHeap is greater
                if(num < median){
                    maxHeap.add(num);
                }
                else{
                	maxHeap.add(minHeap.poll());
                	minHeap.add(num);  
                }
                if(minHeap.isEmpty())
                	median = maxHeap.peek();
                else
                	median = (maxHeap.peek() + minHeap.peek()) * 1.0/ 2;
            break;   
            
            case 0: //same size
                if(num < median){
                    maxHeap.add(num);
                    median = maxHeap.peek();
                }
                else{
                    minHeap.add(num);
                    median = minHeap.peek();
                }
            break;
            case -1: //maxQueue is larger
                if(num < median){   //Number belongs to the max heap
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }
                else{
                    minHeap.add(num);
                }
                if(maxHeap.isEmpty())
                	median = minHeap.peek();
                else
                	median = (maxHeap.peek() + minHeap.peek())*1.0 / 2;
            break;    
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return median;
    }
    
    public static void main(String args[]){
    	MedianFinder medianFinder = new MedianFinder();
    	medianFinder.addNum(1);
    	medianFinder.addNum(2);
    	medianFinder.addNum(3);
    	System.out.println(medianFinder.findMedian());
    }
}
	
// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
