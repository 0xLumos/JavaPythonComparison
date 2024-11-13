import time
import tracemalloc

class LargeObject:
    def __init__(self, value):
        self.__value = value

    def get_value(self):
        return self.__value
def main():
    # Start tracking memory
    tracemalloc.start()

    # Measure memory before creating objects
    memory_before = tracemalloc.get_traced_memory()[1]

    start_time = time.time()  # Record start time

    objects = []
    for i in range(1_000_000):
        objects.append(LargeObject(i))

    end_time = time.time()  # Record end time
    execution_time = end_time - start_time  # Time in seconds

    # Measure memory after creating objects
    memory_after = tracemalloc.get_traced_memory()[1]

    # Calculate memory used
    memory_used = memory_after - memory_before

    print(f"Python Execution time: {execution_time:.6f} seconds")  # Print in seconds
    print(f"Memory used: {memory_used / 1024:.2f} KB")  # Print memory in KB

    # Stop tracking memory
    tracemalloc.stop()

if __name__ == "__main__":
    main()