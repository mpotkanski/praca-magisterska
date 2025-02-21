from time import perf_counter_ns
import sys

def my_function():
  sum = 0
  r = 2000**2000
  for i in range(100**100, 100**100 + 100000000):
    sum = sum + r
		
# Start the stopwatch / counter
t1_start = perf_counter_ns()

my_function()

# Stop the stopwatch / counter
t1_stop = perf_counter_ns()

print((t1_stop-t1_start) / 1000000000, 's')

