public class Assignment01Q05 {

    // Enqueue a value into the queue and return the new last index
    // Queue length is assumed to be sufficient to hold the new value (each graph node is only enqueued once)
    private static int enqueue(int[] queue, int first, int last, int value) {
        queue[last] = value;
        last += 1;
        return last;
    }

    // Dequeue a value from the queue and return the new first index
    private static int dequeue(int[] queue, int first, int last) {
        first += 1;
        return first;
    }
    
    /**
     * Find the shortest path from node i to node j in a directed graph represented by an adjacency matrix m.
     * @param m The adjacency matrix representing the directed graph
     * @param i The starting node
     * @param j The target node
     * @return The shortest path length from i to j, or -1 if no path exists
     */
    public static int findShortestPath(int[][] m, int i, int j) {
        
        // Initialize the graph nodes queue and distance array
        int[] queue = new int[m.length];
        int first = 0;
        int last = 0;
        
        int[] d = new int[m.length];

        for (int u = 0; u < m.length; u++) {
            d[u] = -1;
            queue[u] = -1;
        }

        d[i] = 0;
        last = enqueue(queue, first, last, i);

        // Perform a breadth-first search (BFS) to find the shortest path
        while (first != last) {
            int u = queue[first];
            first = dequeue(queue, first, last);
            
            for (int v = 0; v < m.length; v++) {
                if (m[u][v] == 1 && d[v] == -1) {
                    d[v] = d[u] + 1;
                    last = enqueue(queue, first, last, v);
                }
            }
        }

        return d[j];
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2

        System.out.println(
            findShortestPath(new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}}, 0, 2)); // 1
    }
}