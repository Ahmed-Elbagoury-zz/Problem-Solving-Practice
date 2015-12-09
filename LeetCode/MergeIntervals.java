//http://oj.leetcode.com/problems/merge-intervals/
public class MergeIntervals{
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0)
            return new LinkedList<Interval>();
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.size(), new Comparator<Interval>(){
                public int compare(Interval i1, Interval i2){
                    if(i1.start < i2.start)
                        return -1;
                    else if(i1.start == i2.start)
                        return 0;
                    else
                        return 1;
                }
            });
        
        List<Interval> merged = new LinkedList<Interval>();
        Iterator<Interval> it = intervals.iterator();
        while(it.hasNext()){
            pq.add(it.next());
        }
        
        while(pq.size() > 0){
            Interval curInterval = pq.poll();
            if(pq.size() == 0){
                merged.add(curInterval);
                break;
            }
            Interval nextInterval = pq.poll();
            //Check for overlapping
            if(doOverlap(curInterval, nextInterval)){
                Interval mergedInterval = new Interval(curInterval.start, nextInterval.end > curInterval.end? nextInterval.end: curInterval.end);    //Merge the two intervals
                pq.add(mergedInterval);
            }
            else{
                merged.add(curInterval);
                pq.add(nextInterval);
            }
        }
        return merged;
    }
    
    public boolean doOverlap(Interval i1, Interval i2){
        if(i1 == null || i2 == null)
            return false;
        if(i2.start <= i1.end)
            return true;
        else
            return false;
    }


}