from time import perf_counter_ns

# Start the stopwatch / counter
t1_start = perf_counter_ns()

for i in range(100000000):
  pass

# Stop the stopwatch / counter
t1_stop = perf_counter_ns()

print((t1_stop-t1_start) / 1000000000, 's')

