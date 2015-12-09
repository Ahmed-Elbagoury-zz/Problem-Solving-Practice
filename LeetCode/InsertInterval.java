//https://leetcode.com/problems/insert-interval/
public class InsertInterval{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> newList = new LinkedList<Interval>();
        if(intervals == null || intervals.size() == 0){
            newList.add(newInterval);
            return newList;
        }
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.size(), new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2){
               if(i1.start < i2.start)
                return -1;
               else if(i1.start > i2.start)
                return 1;
               return 0;     
           } 
        });
        Iterator<Interval> it  = intervals.iterator();
        while(it.hasNext()){
            pq.add(it.next());
        }
        pq.add(newInterval);
        while(pq.size() != 0){
            Interval cur = pq.poll();
            if(pq.size() == 0){
                newList.add(cur);
                return newList;
            }
            Interval next = pq.poll();
            if(doOverlap(cur, next)){
               Interval merged = merge(cur, next);
               pq.add(merged);
            }
            else{
                newList.add(cur);
                pq.add(next);
            }
        }
        return newList;
    }
    
    public boolean doOverlap(Interval i1, Interval i2){
        if(i1 == null || i2 == null)
            return false;
        return (i1.start <= i2.start && i2.start <= i1.end) || (i2.start < i1.start && i1.start <= i2.end);
    }
    
    public Interval merge(Interval i1, Interval i2){
        Interval merged = new Interval(i1.start < i2.start? i1.start: i2.start, i1.end > i2.end ? i1.end : i2.end);
        return merged;
    }
}