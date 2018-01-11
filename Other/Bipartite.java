import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Bipartite {
	final int RED = 0;
	final int BLUE = 1;
	public boolean isBipartite(int [][] graph) {
		Set<Integer> redSet = new HashSet<Integer>();
		Set<Integer> blueSet = new HashSet<Integer>();
		Queue<Integer> curQueue = new LinkedList<Integer>();
		Queue<Integer> nextQueue = new LinkedList<Integer>();
		
		curQueue.add(0);
		redSet.add(0);
		int color = RED;
		while(curQueue.size() != 0) {
			while(curQueue.size() != 0) {
				Set<Integer> curSet = color == RED? redSet:blueSet;
				Set<Integer> nextSet = color == RED? blueSet: redSet;
				int node = curQueue.poll();
				for(int i = 0; i < graph.length; i++) {
					if(i == node || graph[node][i] == 0) continue;
					if(curSet.contains(i)) return false;
					if(nextSet.contains(i)) continue;
					nextQueue.add(i);
					nextSet.add(i);
				}
			}
			color = RED + BLUE - color;
			curQueue = nextQueue;
			nextQueue = new LinkedList<Integer>();
		}
		return true;
	}
	public static void main(String[] args) {
//		int graph[][] = {{0, 1, 0, 1},
//	            {1, 0, 1, 0},
//	            {0, 1, 0, 1},
//	            {1, 0, 1, 0}
//	        };
		int graph [][] = {{0, 1, 1, 0}, {1, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
		Bipartite bipartite = new Bipartite();
		System.out.println(bipartite.isBipartite(graph));

	}

}
