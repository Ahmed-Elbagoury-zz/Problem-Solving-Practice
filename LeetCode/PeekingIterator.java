//https://leetcode.com/problems/peeking-iterator/
public class PeekingIterator{
	Iterator<Integer> iterator;
    int next = 0;
    boolean hasNext = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    if(iterator.hasNext()){
	        next = iterator.next();
	        hasNext = true;
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int result = next;
	    if(iterator.hasNext()){
	        next = iterator.next();
	    }
	    else{
	        hasNext = false;
	    }
	    return result;
	}

	@Override
	public boolean hasNext() {
	    return hasNext;
	}

}