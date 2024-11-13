import java.util.ArrayList;
class LargeObject {
    private int value;
    public LargeObject(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
public class Main {
    public static void main(String[] args) {
        ArrayList<LargeObject> objects = new ArrayList<>();

        // Get the runtime instance
        Runtime runtime = Runtime.getRuntime();
        
        // Measure memory before creating objects
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        long startTime = System.nanoTime();

        for (int i = 0; i < 1_000_000; i++) {
            objects.add(new LargeObject(i));
        }
        long endTime = System.nanoTime();
        long executionTimeNs = endTime - startTime; // Time in nanoseconds
        double executionTimeS = executionTimeNs / 1_000_000_000.0; // Convert to seconds
        
        // Measure memory after creating objects
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        
        // Calculate memory used
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Java Execution time: " + executionTimeS + " seconds"); // Print in seconds
        System.out.println("Memory used: " + (memoryUsed / 1024) + " KB"); // Print memory in KB
    }
}
