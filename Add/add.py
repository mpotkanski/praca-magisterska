from time import perf_counter
import random
import sys
from sortedcontainers import SortedSet
from sortedcontainers import SortedDict

def my_function():
  s = [str(i) for i in range(10_000_000)]
    
  random.shuffle(s)
  
  counts = set()
  sorted_set = SortedSet()
  dict1 = {}
  dict2 = SortedDict()
  
  for j in range(0,5):
  
    counts.clear()
    
    # Start the stopwatch / counter 
    t1_start = perf_counter() 
  
    for i in range(0, 10_000_000):
      counts.add(s[i])

    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("set: ", t1_stop-t1_start)
  
  
  for j in range(0,5):
  
    sorted_set.clear()
    
    # Start the stopwatch / counter 
    t1_start = perf_counter() 

    for i in range(0, 10_000_000):
      sorted_set.add(s[i])
		
    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("SortedSet: ", t1_stop-t1_start)
 
  for j in range(0,5):
  
    dict1.clear()
  	
    # Start the stopwatch / counter 
    t1_start = perf_counter() 

    for i in range(0, 10_000_000):
      dict1[s[i]] = s[i]
		
    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("Dictionary: ", t1_stop-t1_start)
    	
  for j in range(0,5):
  
    dict2.clear() 	
  
    # Start the stopwatch / counter 
    t1_start = perf_counter() 

    for i in range(0, 10_000_000):
      dict2[s[i]] = s[i]
		
    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("SortedDict: ", t1_stop-t1_start)
  
my_function()
