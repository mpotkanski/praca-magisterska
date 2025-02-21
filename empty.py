from time import perf_counter_ns

def my_function():
  for i in range(100000000):
    pass
		
# Start the stopwatch / counter
t1_start = perf_counter_ns()

my_function()

# Stop the stopwatch / counter
t1_stop = perf_counter_ns()

print((t1_stop-t1_start) / 1000000000, 's')

